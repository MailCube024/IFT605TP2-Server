/*

 */
package ift605tp2.server;

import contracts.IDerivationCommand;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import udes.ds.agent.BasicEquation;
import udes.ds.agent.Equation;

/**
 *
 */
public class DerivationEngine extends UnicastRemoteObject implements IDerivationCommand {

    private static final long serialVersionUID = 1L;

    public DerivationEngine() throws RemoteException {
        super();
    }

    @Override
    public Equation Derivate(Equation e) throws RemoteException {
        return new BasicEquation(3,2);
    }

}
