/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ift605tp2.server.worker;

import ift605tp2.server.DerivationEngine;
import java.util.logging.Level;
import java.util.logging.Logger;
import udes.ds.agent.Equation;

/**
 *
 * @author Michaël
 */
public class DerivateWorker implements Runnable {

    IDerivationMethod m_method;
    private Equation m_toDerivate;
    private volatile Equation m_result;
    private final long WAITING_TIME = 10000L;

    public DerivateWorker(IDerivationMethod method, Equation toDerivate) {
        m_method = method;
        m_toDerivate = toDerivate;
    }

    public Equation GetResult() {
        return m_result;
    }

    @Override
    public void run() {
        try {
            CalculationWait();
            m_result = m_method.Derivate(m_toDerivate);
        } catch (InterruptedException ex) {
            Logger.getLogger(DerivateWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CalculationWait() throws InterruptedException {
        Thread.sleep(WAITING_TIME);
    }

}
