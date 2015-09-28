/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import constants.Constants;
import contracts.IAdminHandler;
import contracts.IDerivationHandler;
import ift605tp2.server.contracts.ITaskStorage;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Michaël
 */
public class Server{

    private Map<String, Thread> m_mapDerivateTasks;

    protected Server() throws RemoteException {
        super();
        m_mapDerivateTasks = new HashMap<String, Thread>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            ITaskStorage storage = new TaskStorage();
            
            DerivationEngine engine = new DerivationEngine(storage);
            IDerivationHandler stub = (IDerivationHandler) UnicastRemoteObject.exportObject(engine, 0);

            AdminEngine adminEngine = new AdminEngine(storage);
            IAdminHandler adminStub = (IAdminHandler) UnicastRemoteObject.exportObject(adminEngine, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(Constants.DERIVATION_ENGINE_ID, stub);
            registry.rebind(Constants.ADMIN_ENGINE_ID, adminStub);

            System.out.println("Server is started");

        } catch (Exception e) {
            System.out.println("Exception in Derivation server startup:");
            e.printStackTrace();
        }
    }

}
