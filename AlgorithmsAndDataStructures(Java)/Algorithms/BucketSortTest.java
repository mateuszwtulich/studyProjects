import static org.junit.Assert.*;

public class BucketSortTest {

    @org.junit.Test
    public void sort() {
        int [] arr, sorted;
        arr= new int[]{1, 4, 6, 3, 2, 7, 0, 9, 23, 12, 1, 4,0,0,0,543,23,656};
        sorted = new int[]{0,0,0,0,1,1,2,3,4,4,6,7,9,12,23,23,543,656};
        BucketSort bucket = new BucketSort(arr);
        assertArrayEquals(sorted,bucket.sort());
    }
}