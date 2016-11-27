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
import java.util.Date;

class Calculus extends Thread {

    String _s;
    long _l;

    Calculus(long l) {
        _l = l;
    }

    public void run() {
        Date t = new Date(_l);
        _s = new String(t.toString());
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String get() {
        return _s;
    }

    public static void main(String args[]) {
        Calculus c1 = new Calculus(0);
        Calculus c2 = new Calculus(4560000);
        Calculus c3 = new Calculus(System.currentTimeMillis());
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        String s1 = c1.get();
        String s2 = c2.get();
        System.out.println(s1);
        System.out.println(s2);
        c3.start();
        System.out.println(c3.get());
    }
}
