/*

 */
package ift605tp2.server;

import contracts.IDerivationHandler;
import ift605tp2.server.contracts.ITaskStorage;
import ift605tp2.server.worker.DerivateWorker;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import udes.ds.agent.AbstractEquation;
import udes.ds.agent.BasicEquation;
import udes.ds.agent.Constant;
import udes.ds.agent.Equation;
import udes.ds.agent.MultiplicativeEquation;
import udes.ds.agent.SummativeEquation;

/**
 *
 */
public class DerivationEngine implements IDerivationHandler {

    private static final long WAITING_TIME = 5000L;

    private static final long serialVersionUID = 1L;
    protected ITaskStorage m_storage;

    public DerivationEngine(ITaskStorage storage) throws RemoteException {
        super();
        m_storage = storage;
    }

    @Override
    public Equation Derivate(Equation e) throws RemoteException {
        if (e instanceof AbstractEquation) {
            try {
                DerivateWorker worker = new DerivateWorker((Equation e1) -> DerivateAbstract((AbstractEquation) e1), e);
                Thread t = new Thread(worker);
                m_storage.AddTask(t.getName(), t);
                t.start();
                t.join();

                return worker.GetResult();

            } catch (InterruptedException ex) {
                return null;
            }
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    private AbstractEquation DerivateAbstract(AbstractEquation e) {
        CalculationWait();
        if (e instanceof Constant) {
            return Derivate((Constant) e);
        }
        if (e instanceof BasicEquation) {
            return Derivate((BasicEquation) e);
        }
        if (e instanceof SummativeEquation) {
            return Derivate((SummativeEquation) e);
        }
        if (e instanceof MultiplicativeEquation) {
            return Derivate((MultiplicativeEquation) e);
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    private AbstractEquation Derivate(Constant e) {
        return new Constant(0);
    }

    private AbstractEquation Derivate(BasicEquation e) {
        return new BasicEquation(e.getCoefficient() * e.getExponent(), e.getExponent() - 1);
    }

    private AbstractEquation Derivate(SummativeEquation e) {
        return new SummativeEquation(DerivateAbstract(e.getFirst()), DerivateAbstract(e.getSecond()));
    }

    private AbstractEquation Derivate(MultiplicativeEquation e) {
        MultiplicativeEquation first = new MultiplicativeEquation(DerivateAbstract(e.getFirst()), e.getSecond());
        MultiplicativeEquation second = new MultiplicativeEquation(e.getFirst(), DerivateAbstract(e.getSecond()));

        return new SummativeEquation(first, second);
    }

    private void CalculationWait() {
        try {
            Thread.sleep(WAITING_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(DerivationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
