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
public class Cptb extends Thread {

    private static int _cpt = 1;
    private String _name;
    private static int _nbrP1 = 0;
    private static int _nbrP2 = 0;

    public Cptb(String name) {
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
        // System.out.println(Thread.currentThread().getPriority());
    }

    public static void main(String args[]) {
        Cptb thr1 = new Cptb("Processus1");
        Cptb thr2 = new Cptb("Processus2");
        thr1.run();
        thr2.start();
        System.out.println("Numbre des threads: " + java.lang.Thread.activeCount());
        try {
            thr2.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Nombre d'incrementation par Processus1:" + _nbrP1);
        System.out.println("Nombre d'incrementation par Processus2:" + _nbrP2);
        System.out.println("VALEUR " + Cptb.getValeur());
    }
}
/*
    - Thread.start () crée un nouveau thread et possède son propre scénario d'exécution.
       Thread.start () appelle la méthode run () de façon asynchrone, ce qui modifie l'état du nouveau thread vers Runnable.
        Mais Thread.run () ne crée pas de nouveau thread. Au lieu de cela, il exécute la méthode run dans le thread en cours en synchronisation.
        Si on utilise Thread.run () alors on n'utilise pas les fonctionnalités de multi threading du tout.

    - Le Nombre des threads est 2
    - Pas de variables partagée 
    - Le Nombre d'incrementation par Processus1:100000
    - Le Nombre d'incrementation par Processus2:100000
    - La Valeur affiche est 200001
    - Le Résultat est fixe(200001), Variable _cpt n'est pas partagée entre les threads et puisque nous n'utilisons pas les fonctionnalités de multi threading
     alors chaque thread est execute' séparément
*/