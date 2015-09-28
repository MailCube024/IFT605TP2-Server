/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server.contracts;

/**
 *
 * @author Michaël
 */
public interface ITaskStorage {
    public boolean AddTask(String name, Thread t);
    public boolean RemoveTask(String name);
    
    public String[] GetCurrentTasks();
}
