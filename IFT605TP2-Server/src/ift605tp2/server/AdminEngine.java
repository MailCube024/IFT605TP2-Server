/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import contracts.IAdminHandler;
import ift605tp2.server.contracts.ITaskStorage;
import java.rmi.RemoteException;

/**
 *
 * @author Michaël
 */
public class AdminEngine extends DerivationEngine implements IAdminHandler {

    public AdminEngine(ITaskStorage storage) throws RemoteException {
        super(storage);
    }

    @Override
    public boolean StopTask(String name) throws RemoteException {
        return m_storage.RemoveTask(name);
    }

    @Override
    public String[] GetCurrentlyRunningTasks() throws RemoteException {
        return m_storage.GetCurrentTasks();
    }
}
