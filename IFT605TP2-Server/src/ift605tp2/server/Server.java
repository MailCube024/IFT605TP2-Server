/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import constants.Constants;
import contracts.IDerivationCommands;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import udes.ds.agent.Equation;

/**
 *
 * @author Michaël
 */
public class Server {

    protected Server() throws RemoteException {
        super();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try {
                    
            DerivationEngine engine = new DerivationEngine();
            Registry registry = LocateRegistry.createRegistry(Constants.RMI_PORT);
            registry.rebind(Constants.DERIVATION_ENGINE_ID, engine);
            System.out.println("Server is started");
            
        } catch (Exception e) {
            System.out.println("Exception in Derivation server startup:");
            e.printStackTrace();
        }
    }

//    @Override
//    public Equation Derivate(Equation e) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
