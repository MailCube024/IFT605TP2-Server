/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import contracts.IAdminHandler;
import java.rmi.RemoteException;
import java.util.Random;

/**
 *
 * @author Michaël
 */
public class AdminEngine extends DerivationEngine implements IAdminHandler {

    private long m_adminKey = -1;
    
    public AdminEngine() throws RemoteException {
        super();
        
        Random rand = new Random();
        
        do {
            m_adminKey = rand.nextLong();
        } while(m_adminKey == -1);
    }

    @Override
    public long Connect(String username, String password) throws RemoteException {
        return m_adminKey;
    }

    @Override
    public boolean StopTask(String name, long adminKey) throws RemoteException {
        if (adminKey != m_adminKey)
            return false;
        
        return true;
    }

    @Override
    public String[] GetCurrentlyRunningTask(long adminKey) throws RemoteException {
        if (adminKey != m_adminKey)
            return null;
        
        return new String[]{"T1", "T2", "T3", "T4", "T5"};
    }

}
