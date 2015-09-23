/*

 */
package ift605tp2.server;

import contracts.IDerivationCommands;
import java.rmi.RemoteException;
import udes.ds.agent.Equation;


/**
 *
 */
public class DerivationEngine implements IDerivationCommands{

    public DerivationEngine(){
        super();
    }
    
    @Override
    public Equation Derivate(Equation e) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
