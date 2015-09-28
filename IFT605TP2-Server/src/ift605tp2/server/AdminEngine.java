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
    public long Connect(String username, String password) throws RemoteException {
        return 2;
    }

    @Override
    public boolean StopTask(String name, long adminKey) throws RemoteException {
        Thread t = m_storage.GetTask(name);
        t.interrupt();
        return m_storage.RemoveTask(name);
    }

    @Override
    public String[] GetCurrentlyRunningTask(long adminKey) throws RemoteException {
        return m_storage.GetCurrentTasks();
    }
}
