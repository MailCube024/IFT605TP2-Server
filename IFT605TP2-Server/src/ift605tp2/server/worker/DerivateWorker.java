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
public class DerivateWorker implements Runnable {

    IDerivationMethod m_method;
    private Equation m_toDerivate;
    private volatile Equation m_result;

    public DerivateWorker(IDerivationMethod method, Equation toDerivate) {
        m_method = method;
        m_toDerivate = toDerivate;
    }

    public Equation GetResult() {
        return m_result;
    }

    @Override
    public void run() {
        m_result = m_method.Derivate(m_toDerivate);
    }

}
