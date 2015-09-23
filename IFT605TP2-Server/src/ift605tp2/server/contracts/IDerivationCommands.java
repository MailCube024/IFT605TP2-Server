
package ift605tp2.server.contracts;

import java.rmi.Remote;
import java.rmi.RemoteException;
import udes.ds.agent.Equation;

/**
 *
 */
public interface IDerivationCommands extends Remote {
    Equation Derivate(Equation e) throws RemoteException;
}
