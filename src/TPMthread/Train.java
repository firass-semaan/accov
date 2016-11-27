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
public class Train extends Thread{

    private int _vi;
    private String _nom;

    public Train(int v, String n) {
        _vi = v;
        _nom = n;
    }

    public void run() {
        System.out.println("le train " + _nom + " part");
        try {
            Thread.sleep(_vi * 500);
            System.out.println("le train " + _nom + " roule");
            Thread.sleep(_vi * 500);
            System.out.println("le train " + _nom + " s'arrête");
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        Thread tgv = new Thread(new Train(10, "TGV"));
        Thread corail = new Thread(new Train(20, "CORAIL"));
        tgv.start();
        corail.start();
        System.out.println("fin du main");
    }
}
/*
    - Le programme principal n'attend pas ses threads pour finir puisque le main n'appelle pas 
       la methode "Join"  ainsi, il imprimera "fin du principal (main)" d'abord.
        Après 500ms les 2 threads commenceront leur exécution selon leurs priorite's 
       et le scheduler,
        Thread attendra 500ms avant d'imprimer et finir son travail.
*/