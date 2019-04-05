public class Print {

    private static int counterOfA = 0;
    private static int counterOfB = 0;

    synchronized void print(String typ, int t){

        if("A" == typ)counterOfA++;
        else counterOfB++;

        while(counterOfA>counterOfB){
            try {
                wait(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        System.out.println(typ + ", AL: " + counterOfA + ", BL: " + counterOfB);
    }
}
