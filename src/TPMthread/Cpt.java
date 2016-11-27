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
public class Cpt extends Thread {

    private static int _cpt = 1;
    private String _name;
    private static int _nbrP1 = 0;
    private static int _nbrP2 = 0;

    public Cpt(String name) {
        _name = name;
    }

    public static int getValeur() {
        return _cpt;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            int _c = _cpt;
            _cpt = _c + 1;
            if (_name == "Processus1") {
                _nbrP1++;
            } else {
                _nbrP2++;
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("VALEUR " + Cpt.getValeur());
        Cpt thr1 = new Cpt("Processus1");
        Cpt thr2 = new Cpt("Processus2");
        
        thr1.start();
        thr2.start();
        System.out.println("Nombre des threads: " + java.lang.Thread.activeCount());
        try 
        {
            thr1.join();
            thr2.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Nombre d'incrementation par Processus1:" + _nbrP1);
        System.out.println("Nombre d'incrementation par Processus2:" + _nbrP2);
        System.out.println("VALEUR " + Cpt.getValeur());
    }
}

/*
    - Le Nombre des threads est 3, le main thread + 2 threads cree.
    - Le Nombre d'incrementation de la variable _cpt est 100000 par chaque thread
    - La Valeur affiche' est variable 
    - Le Resultat est variable car _cpt est une variable partagée entre les differents threads
*/
