import java.util.concurrent.Semaphore;

public class Konto {

    private int V;
    private Semaphore sem = new Semaphore(1);

    Konto(int V){
        this.V = V;
    }

    void takeValue(int v){
        myAcquire();
        V -= v;
        sem.release();
    }

    void putValue(int v){

        myAcquire();
        V += v;
        sem.release();
    }

    int getValue(){
        return V;
    }

    void myAcquire(){
        try {
            sem.acquire();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
