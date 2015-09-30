/*

 */
package ift605tp2.server;

import contracts.IDerivationHandler;
import ift605tp2.server.contracts.ITaskStorage;
import ift605tp2.server.worker.DerivateWorker;
import java.rmi.RemoteException;
import udes.ds.agent.AbstractEquation;
import udes.ds.agent.Equation;

/**
 *
 */
public class DerivationEngine implements IDerivationHandler {

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
                DerivateWorker worker = new DerivateWorker(e);
                Thread t = new Thread(worker);
                m_storage.AddTask(t.getName(), t);
                t.start();
                t.join();
                m_storage.RemoveTask(t.getName());
                return worker.GetResult();

            } catch (InterruptedException ex) {
                return null;
            }
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /*
    private AbstractEquation DerivateAbstract(AbstractEquation e) {
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
        
        
        return e.derivate();

        //throw new UnsupportedOperationException("Not supported yet.");
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
    */
}
