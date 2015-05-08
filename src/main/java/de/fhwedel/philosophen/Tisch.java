package de.fhwedel.philosophen;

/**
 *
 */
public class Tisch implements Runnable {

    private final Stick[] sticks = new Stick[5];

    public Tisch() {
        for (int i = 0; i < this.sticks.length; i++) {
            sticks[i] = new Stick();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosoph(sticks[i], sticks[(i + 1) % this.sticks.length])).start();
        }
    }

    public static void main(String[] args) {
        new Tisch().run();
    }

}
