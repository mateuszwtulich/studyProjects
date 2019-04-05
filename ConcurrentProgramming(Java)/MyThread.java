import java.util.concurrent.Semaphore;

public class MyThread extends Thread{

    private int T;
    private Bank bank;
    private int liczbaKont;
    private int vTrans;

    MyThread(int T, int vTrans, int liczbaKont, Bank bank){
        this.T = T;
        this.bank = bank;
        this.vTrans = vTrans;
        this.liczbaKont = liczbaKont;
    }

    @Override
    public void run() {

        for (int i = 0; i < T; i++) {
            bank.takeKonto((int) (Math.random() * liczbaKont)).takeValue(vTrans);
            bank.takeKonto((int) (Math.random() * liczbaKont)).putValue(vTrans);
        }
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public int getLiczbaKont() {
        return liczbaKont;
    }

    public void setLiczbaKont(int liczbaKont) {
        this.liczbaKont = liczbaKont;
    }

    public int getvTrans() {
        return vTrans;
    }

    public void setvTrans(int vTrans) {
        this.vTrans = vTrans;
    }
}
