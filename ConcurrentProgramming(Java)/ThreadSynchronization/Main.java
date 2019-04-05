public class Main {

    public static void main(String[] args) {

        System.out.println("a" + "v");
        String first = "a";
        String second = "b";
        String third = first + second;
        System.out.println(third);
        
        int numberOfThreads = 20;
        MyThread[] myThreads = new MyThread[numberOfThreads];
        int time[] = {23,45,63,23,54};
        Print print = new Print();

        for (int i = 0; i < numberOfThreads/2; i++) {
            MyThread t1 = new MyThread("A",time, print);
            MyThread t2 = new MyThread("B",time, print);
            myThreads[i*2] = t1;
            myThreads[i*2+1] = t2;
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                myThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numberOfThreads; i++) {
            myThreads[i].start();
        }
    }
}
