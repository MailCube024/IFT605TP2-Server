/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import ift605tp2.server.contracts.IDerivationCommands;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Michaël
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "DerivationEngine";
            IDerivationCommands engine = new DerivationEngine();
            IDerivationCommands stub = (IDerivationCommands) UnicastRemoteObject.exportObject(engine, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("DerivationEngine bound");

        } catch (Exception e) {
            System.err.println("DerivationServer Exception:");
            e.printStackTrace();
        }
    }
}
