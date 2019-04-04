import org.junit.Test;

import java.io.File;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class FifoTest {
    Fifo<Student> fifo = new Fifo<>();
    Student student1 = new Student();
    Student student2 = new Student();
    Student student3 = new Student();

    @Test
    public void remove(){
        fifo.add(student1);
        fifo.add(student2);
        fifo.add(student3);
        assertSame(student1, fifo.remove());
        assertEquals(student2, fifo.get(0));
        assertEquals(student3, fifo.get(1));
        assertEquals(null, fifo.get(2));
    }

    @Test
    public void poll() {
        assertEquals(null, fifo.poll());
        fifo.add(student1);
        fifo.add(student2);
        fifo.add(student3);
        fifo.poll();
        assertEquals(student2, fifo.get(0));
        assertEquals(student3, fifo.get(1));
        assertSame(null, fifo.get(2));
    }

    @Test
    public void offer() {
        fifo.offer(student1);
        fifo.offer(student2);
        fifo.offer(student3);
        assertEquals(student1, fifo.get(0));
        assertEquals(student2, fifo.get(1));
        assertEquals(student3, fifo.get(2));
    }

    @Test
    public void element() {
        fifo.add(student1);
        fifo.add(student2);
        fifo.add(student3);
        assertEquals(student1, fifo.element());
        fifo.remove();
        assertEquals(student2, fifo.element());
    }

    @Test
    public void peek() {
        assertEquals(null, fifo.peek());
        fifo.add(student1);
        fifo.add(student2);
        fifo.add(student3);
        assertEquals(student1, fifo.peek());
        fifo.remove();
        assertEquals(student2, fifo.peek());
    }
}