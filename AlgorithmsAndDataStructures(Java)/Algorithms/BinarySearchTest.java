import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
   BinarySearch binary = new BinarySearch(13);
   //BinarySearch binary = new BinarySearch(1000000, array);

    @org.junit.Test
    public void addElem() {
        binary.addElem();
    }

    @org.junit.Test
    public void search() {
        binary.addElem(2);
        binary.addElem(3);
        binary.addElem(4);
        binary.addElem(54);
        binary.addElem(6);
        binary.addElem(76);
        binary.addElem(5);
        binary.addElem(654);
        binary.addElem(98);
        binary.addElem(42342);
        binary.addElem(643);
        binary.addElem(76324);
        binary.addElem(53423);
     //   binary.addElem(4634634);
        assertEquals("not", binary.search(0));
        assertEquals("1", binary.search(2));
        assertEquals("2", binary.search(3));
        assertEquals("6",binary.search(54));
        assertEquals("3",binary.search(4));
        assertEquals("4", binary.search(5));
        assertEquals("5",binary.search(6));
        assertEquals("10",binary.search(654));
        assertEquals("8",binary.search(98));
        assertEquals("7",binary.search(76));
        assertEquals("11",binary.search(42342));
        assertEquals("9", binary.search(643));
        assertEquals("12",binary.search(53423));
        assertEquals("13",binary.search(76324));
    }
}
