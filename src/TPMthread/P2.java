/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmthread;

/**
 *
 * @author Firas Semaan
 */
public class P2 extends Thread {

    private static int tick = 0;

    P2() {
    }

    public void run() {
        while (tick < 40000000) {
            tick++; // tick est un entier initialisé à 0 
            // tick représente le nombre de millisecondes écoulées depuis 
            // le début de l'exécution du CoureurEgoiste 
            if ((tick % 5000) == 0) {
                System.out.println("Thread #" + Thread.currentThread().getName()
                        + " tick = " + tick);
            }
        }

    }

    public static void main(String args[]) {
        P2 thr1 = new P2();
        P2 thr2 = new P2();
        P2 thr3 = new P2();

        thr1.start();
        thr2.start();
        thr3.start();
        try {
            thr1.join();
            thr2.join();
            thr3.join();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
