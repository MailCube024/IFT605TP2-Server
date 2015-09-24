/*

 */
package ift605tp2.server;

import contracts.IDerivationCommand;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import udes.ds.agent.AbstractEquation;
import udes.ds.agent.BasicEquation;
import udes.ds.agent.Constant;
import udes.ds.agent.Equation;
import udes.ds.agent.MultiplicativeEquation;
import udes.ds.agent.SummativeEquation;

/**
 *
 */
public class DerivationEngine implements IDerivationCommand {

    private static final long serialVersionUID = 1L;

    public DerivationEngine() throws RemoteException {
        super();
    }

    @Override
    public Equation Derivate(Equation e) throws RemoteException {
        if (e instanceof AbstractEquation)
            return Derivate((AbstractEquation)e);
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private AbstractEquation Derivate(AbstractEquation e) {
        if (e instanceof Constant)
            return Derivate((Constant)e);
        else if (e instanceof BasicEquation)
            return Derivate((BasicEquation)e);
        else if (e instanceof SummativeEquation)
            return Derivate((SummativeEquation)e);
        else if (e instanceof MultiplicativeEquation)
            return Derivate((MultiplicativeEquation)e);

        throw new UnsupportedOperationException("Not supported yet.");
    }
        
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

}
