import org.junit.Test;

import static org.junit.Assert.*;

public class LifoTest {
    Lifo<Student> lifo = new Lifo<>();
    Student student1 = new Student();
    Student student2 = new Student();
    Student student3 = new Student();

    @Test
    public void add() {
        lifo.add(student1);
        lifo.add(student2);
        lifo.add(student3);
        assertEquals(student3, lifo.get(0));
        assertEquals(student2, lifo.get(1));
        assertEquals(student1, lifo.get(2));
        assertEquals(null, lifo.get(3));
    }

    @Test
    public void remove(){
        lifo.add(student1);
        lifo.add(student2);
        lifo.add(student3);
        assertSame(student3, lifo.remove());
        assertEquals(student2, lifo.get(0));
        assertEquals(student1, lifo.get(1));
        assertEquals(null, lifo.get(2));
    }

    @Test
    public void poll() {
        assertEquals(null, lifo.poll());
        lifo.add(student1);
        lifo.add(student2);
        lifo.add(student3);
        lifo.poll();
        assertEquals(student2, lifo.get(0));
        assertEquals(student1, lifo.get(1));
        assertSame(null, lifo.get(2));
    }

    @Test
    public void offer() {
        lifo.offer(student1);
        lifo.offer(student2);
        lifo.offer(student3);
        assertEquals(student3, lifo.get(0));
        assertEquals(student2, lifo.get(1));
        assertEquals(student1, lifo.get(2));
    }

    @Test
    public void element() {
        lifo.add(student1);
        lifo.add(student2);
        lifo.add(student3);
        assertEquals(student3, lifo.element());
        lifo.remove();
        assertEquals(student2, lifo.element());
    }

    @Test
    public void peek() {
        assertEquals(null, lifo.peek());
        lifo.add(student1);
        lifo.add(student2);
        lifo.add(student3);
        assertEquals(student3, lifo.peek());
        lifo.remove();
        assertEquals(student2, lifo.peek());
    }
}