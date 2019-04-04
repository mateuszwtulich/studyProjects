public class BucketSort {
    private int inArr[];
    private int exArr[];
    private int counter[];

    public BucketSort(int exArr[]) {
        this.exArr = exArr;
        int max = exArr[0];
        for (int i : exArr) {
            if (max < i) {
                max = i;
            }
        }
        counter = new int[max+1];
        inArr = new int[max+1];
    }

    public int[] sort() {
        for (int i = 0; i < exArr.length; i++) {
            counter[exArr[i]]++;
            inArr[exArr[i]] = exArr[i];
            }

        int j=0;

        for (int i : inArr) {
            while(counter[i]!=0) {
                System.out.print(i + ", ");
                exArr[j] = i;
                counter[i]--;
                j++;
            }
        }
        return exArr;
    }
}
