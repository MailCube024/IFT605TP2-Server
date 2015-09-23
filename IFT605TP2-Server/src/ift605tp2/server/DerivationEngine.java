/*

 */
package ift605tp2.server;

import contracts.IDerivationCommands;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import udes.ds.agent.Equation;
import udes.ds.agent.SummativeEquation;

/**
 *
 */
public class DerivationEngine extends UnicastRemoteObject implements IDerivationCommands {

    private static final long serialVersionUID = 1L;

    public DerivationEngine() throws RemoteException {
        super();
    }

    @Override
    public boolean Derivate(String e) throws RemoteException {
        return true;
    }

}
