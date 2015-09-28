/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import contracts.IAdminHandler;
import java.rmi.RemoteException;

/**
 *
 * @author Michaël
 */
public class AdminEngine extends DerivationEngine implements IAdminHandler {

    public AdminEngine() throws RemoteException {
        super();
    }

    @Override
    public boolean StopTask(String name) throws RemoteException {
        return true;
    }

    @Override
    public String[] GetCurrentlyRunningTask() throws RemoteException {
        return new String[]{"T1", "T2", "T3", "T4", "T5"};
    }

}
