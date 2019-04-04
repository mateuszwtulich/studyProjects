import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void sort() {
    }

    @org.junit.Test
    public void getArray() {
        int [] array = {1,32,6,5,8,54,76,77,65,87};
        QuickSort quick = new QuickSort(array);
        quick.sort(array,0,array.length-1);
        int [] arrayEx = {1,5,6,8,32,54,65,76,77,87};
        assertArrayEquals(arrayEx, quick.getArray());
    }

}