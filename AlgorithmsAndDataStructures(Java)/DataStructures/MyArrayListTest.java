import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MyArrayListTest {
    Student student1 = new Student();
    Student student2 = new Student();
    Student student3 = new Student();
    MyArrayList<Student> array = new MyArrayList<>();

    @org.junit.Test
    public void size() {
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);

        assertEquals(14, array.size());
    }

    @org.junit.Test
    public void indexOf() {
        array.add(student1);
        array.add(student1);
        assertEquals(1, array.indexOf(student1));

    }

    @org.junit.Test
    public void set() {
        array.add(student1);
        array.add(student2);
        assertSame(student1, array.set(0, student2));
        assertNotSame(student1, array.set(1, student1));
    }

    @org.junit.Test
    public void add() {
        assertTrue(array.add(student1));
        assertTrue(array.add(student2));
        assertTrue(array.add(student1));
        assertTrue(array.add(student2));
        assertTrue(array.add(student1));
        assertTrue(array.add(student2));
        assertTrue(array.add(student1));
        assertTrue(array.add(student1));
        assertTrue(array.add(student2));
        assertTrue(array.add(student1));
        assertTrue(array.add(student2));
        assertTrue(array.add(student1));
        assertTrue(array.add(student1));
        assertTrue(array.add(student2));
        assertTrue(array.add(student1));
        assertTrue(array.add(student1));
        System.out.println(array.get(0));
        System.out.println(array.get(15));
        System.out.println(array.get(16));
        System.out.println(array.get(5));
    }

    @org.junit.Test
    public void add1() {
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student2);
        System.out.println("Przed: " + array.get(0));
        System.out.println(array.get(1));
        assertTrue(array.add(0, student2));
        System.out.println("Po: " + array.get(0));
        System.out.println(array.get(1));
        System.out.println(array.get(2));
        System.out.println(array.get(15));
        System.out.println(array.get(16));
        System.out.println(array.get(17));
        System.out.println(array.get(19));
    }

    @org.junit.Test
    public void remove() {
        array.add(student1);
        array.add(student2);
        assertSame(student1, array.remove(0));
        System.out.println(array.get(0));
        System.out.println(array.get(1));
    }

    @org.junit.Test
    public void clear() {
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student2);
        System.out.println(array.size());
        array.clear();

        for (int i = 0; i < array.size(); i++){
            assertEquals(null, array.get(i));
        }
        System.out.println(array.size());
    }

    @org.junit.Test
    public void addAll() {
        ArrayList<Student> col = new ArrayList<>();
        col.add(student1);
        col.add(student2);
        col.add(student3);
        col.add(student1);
        col.add(student2);
        col.add(student3);
        col.add(student2);
        col.add(student3);


        array.add(student3);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student2);

        assertTrue(array.addAll(col));
        assertEquals(student3, array.get(20));
        assertEquals(student2, array.get(21));
        assertEquals(student3, array.get(22));
        assertEquals(student3, array.get(0));
        assertEquals(student1, array.get(1));
    }

    @org.junit.Test
    public void addAll1() {
        ArrayList<Student> col = new ArrayList<>();
        col.add(student1);
        col.add(student2);
        col.add(student3);
        col.add(student1);
        col.add(student2);
        col.add(student3);
        col.add(student2);
        col.add(student3);


        array.add(student3);
        array.add(student2);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student1);
        array.add(student2);

        assertTrue(array.addAll(5,col));
        assertEquals(student2, array.get(23));
        assertEquals(student1, array.get(22));
        assertEquals(student1, array.get(5));
    }

    @org.junit.Test
    public void get() {
        array.add(student1);
        array.add(student2);
        assertSame(student1, array.get(0));
        assertNotSame(student1, array.get(1));
    }

    @Test
    public void iterator() {
        Iterator<Student> iter = array.iterator();
        array.add(0,student3);
        array.add(1,student2);
        array.add(2,student1);
        assertTrue(iter.hasNext());
        assertEquals(student3, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(student2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(student1, iter.next());
    }
}