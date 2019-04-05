public class Bank {
    private final int K;
    private int vKont;
    private Konto[] kont;

    Bank(int K, int vKont){
        this.K = K;
        this.vKont = vKont;
        kont = new Konto[K];
        for (int i = 0; i < K; i++) {
            kont[i] = new Konto(vKont);
        }
    }

    Konto takeKonto(int k){
        return kont[k];
    }

    int sumaVKont(){
        int suma = 0;
        for (int i = 0; i < K ; i++) {
            suma += kont[i].getValue();
        }
        return suma;
    }
}
