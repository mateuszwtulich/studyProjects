import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    MyLinkedList<Student> list = new MyLinkedList<>();
    Student student1 = new Student();
    Student student2 = new Student();
    Student student3 = new Student();

    @org.junit.Test
    public void size() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        assertEquals(3,list.size());
    }

    @org.junit.Test
    public void indexOf() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        assertEquals(1,list.indexOf(student2) );
    }

    @org.junit.Test
    public void add() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        assertSame(student2, list.get(1));
        assertEquals(student3, list.get(2));
    }

    @org.junit.Test
    public void get() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        assertSame(student3, list.get(2));
    }

    @Test
    public void remove() {
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.remove(0);
        assertSame(student3, list.get(1));
        assertEquals(student2, list.get(0));
    }

    @Test
    public void add1() {
        list.add(student1,0);
        list.add(student2,1);
        list.add(student3,2);
        list.add(student3, 1);
        list.add(student1, list.size());
        assertSame(student1, list.get(0));
        assertEquals(student3, list.get(1));
        assertSame(student2, list.get(2));
        assertEquals(student3, list.get(3));
        assertEquals(student1, list.get(4));
        assertEquals(null, list.get(5));
    }
}