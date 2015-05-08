package de.fhwedel.philosophen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Stick {

    private boolean taken = false;

    public synchronized void take() {
        if (taken) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Stick.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        taken = true;
    }

    public boolean isTaken() {
        return taken;
    }

    public synchronized void put() {
        this.taken = false;
        this.notify();
    }

}
