/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server.worker;

import udes.ds.agent.Equation;

/**
 *
 * @author Michaël
 */
public interface IDerivationMethod {
    public Equation Derivate(Equation e);
}
