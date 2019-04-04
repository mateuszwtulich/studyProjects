import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void sort() {
        BubbleSort bubble = new BubbleSort();
        int array[] = new int[]{23,43,5,55,32,1,4,0,5,3};
        int sorted[] = new int[]{0,1,3,4,5,5,23,32,43,55};
        assertArrayEquals(sorted, bubble.sort(array));
    }
}