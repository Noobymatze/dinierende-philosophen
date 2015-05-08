package de.fhwedel.philosophen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Philosoph implements Runnable {

    private final Stick left;
    private final Stick right;

    public Philosoph(Stick left, Stick right) {
        this.left = left;
        this.right = right;
    }

    public void think() {
        System.out.println("Thinking...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosoph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void run() {
        while(true) {
            this.think();

            System.out.println("Take left...");
            left.take();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Philosoph.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Take right...");
            if (right.isTaken()) {
                left.put();
            }
            else {
                right.take();

                this.eat();
                this.right.put();
                this.left.put();
            }
        }
    }

    private void eat() {
        System.out.println("Eating...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosoph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
