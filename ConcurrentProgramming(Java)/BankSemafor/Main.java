import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        int liczbaTrans = 1000;
        int liczbaKont = 100;
        int liczbaW = 10;
        int vkont = 100;
        int vtrans = 1;
        Bank bank = new Bank(liczbaKont, vkont);
        MyThread[] myThreads = new MyThread[liczbaW];

        for (int i = 0; i < liczbaW ; i++) {
            MyThread t1 = new MyThread(liczbaTrans, vtrans, liczbaKont, bank);
            myThreads[i] = t1;
        }

        for (int i = 0; i < liczbaW ; i++) {
            myThreads[i].start();
        }

        try{
            for (int i = 0; i < liczbaW; i++) {
                myThreads[i].join();
            }
        } catch (InterruptedException e) {
        }

        System.out.println("Miało być " + 100*100 + ",a jest: " + bank.sumaVKont());
    }
}