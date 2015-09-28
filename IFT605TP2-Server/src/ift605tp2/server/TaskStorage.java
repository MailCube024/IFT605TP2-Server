/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server;

import ift605tp2.server.contracts.ITaskStorage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Michaël
 */
public class TaskStorage implements ITaskStorage {

    private Map<String, Thread> m_mapWorkingTasks;

    public TaskStorage() {
        m_mapWorkingTasks = new HashMap<>();
    }

    @Override
    public synchronized boolean AddTask(String name, Thread t) {
        if (!m_mapWorkingTasks.containsKey(name)) {
            m_mapWorkingTasks.put(name, t);
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean RemoveTask(String name) {
        if (m_mapWorkingTasks.containsKey(name)) {
            m_mapWorkingTasks.remove(name);
            return true;
        }
        return false;
    }

    @Override
    public synchronized String[] GetCurrentTasks() {
        Set<String> keys = m_mapWorkingTasks.keySet();
        return keys.toArray(new String[keys.size()]);
    }

}
