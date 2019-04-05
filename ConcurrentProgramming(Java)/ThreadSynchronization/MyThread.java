import java.lang.String;

public class MyThread extends Thread {

    private String typ;
    private Print cPrint;
    private int[] time;

    MyThread(String typ, int[]  time, Print cPrint){
     this.typ = typ;
     this.time = time;
     this.cPrint = cPrint;
    }

    @Override
    public void run() {
        for (int t: time) {
            cPrint.print(typ, t);
        }
    }
}
