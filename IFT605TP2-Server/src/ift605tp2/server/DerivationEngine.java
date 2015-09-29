/*

 */
package ift605tp2.server;

import contracts.IDerivationHandler;
import java.rmi.RemoteException;
import udes.ds.agent.Equation;

/**
 *
 */
public class DerivationEngine implements IDerivationHandler {

    private static final long serialVersionUID = 1L;

    public DerivationEngine() throws RemoteException {
        super();
    }

    @Override
    public Equation Derivate(Equation e) throws RemoteException {
        return e.derivate();
    }
    
    /*
    private AbstractEquation Derivate(AbstractEquation e) {
       
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
    */
    
    /*
    private AbstractEquation Derivate(Constant e) {
        return new Constant(0);
    }

    private AbstractEquation Derivate(BasicEquation e) {
        return new BasicEquation(e.getCoefficient() * e.getExponent(), e.getExponent() - 1);
    }

    private AbstractEquation Derivate(SummativeEquation e) {
        return new SummativeEquation(Derivate(e.getFirst()), Derivate(e.getSecond()));
    }

    private AbstractEquation Derivate(MultiplicativeEquation e) {
        MultiplicativeEquation first = new MultiplicativeEquation(Derivate(e.getFirst()), e.getSecond());
        MultiplicativeEquation second = new MultiplicativeEquation(e.getFirst(), Derivate(e.getSecond()));

        return new SummativeEquation(first, second);
    }
    */
}
