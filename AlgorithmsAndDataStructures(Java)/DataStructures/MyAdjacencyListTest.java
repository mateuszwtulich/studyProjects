import org.junit.Test;

import static org.junit.Assert.*;

public class MyAdjacencyListTest {
    MyAdjacencyList my = new MyAdjacencyList(4);

    @org.junit.Test
    public void addEdge() {
        my.addEdge(0,1);
        my.addEdge(0,43);
        my.addEdge(1,67);
        my.addEdge(1,32);
        my.addEdge(3,23);
        my.addEdge(2,43);
        assertEquals(my.hasEdge(0,1), true);
        assertEquals(my.hasEdge(1,32), true);
        assertEquals(my.hasEdge(2,43), true);
        assertEquals(my.hasEdge(0,43), true);
        assertEquals(my.hasEdge(3,2), false);
    }

    @org.junit.Test
    public void removeEdge() {
        my.addEdge(0,1);
        my.addEdge(0,43);
        my.addEdge(1,67);
        my.addEdge(1,32);
        my.addEdge(3,23);
        my.addEdge(2,43);
        assertEquals(my.hasEdge(0,1), true);
        assertEquals(my.hasEdge(1,32), true);
        assertEquals(my.hasEdge(2,43), true);
        my.removeEdge(1,32);
        my.removeEdge(3,23);
        assertEquals(my.hasEdge(1,32), false);
        assertEquals(my.hasEdge(3,23), false);
    }

    @org.junit.Test
    public void hasEdge() {
        my.addEdge(0,1);
        my.addEdge(0,43);
        my.addEdge(1,67);
        my.addEdge(1,32);
        my.addEdge(3,23);
        my.addEdge(2,43);
        assertEquals(my.hasEdge(0,1), true);
        assertEquals(my.hasEdge(1,32), true);
        assertEquals(my.hasEdge(2,43), true);
        assertEquals(my.hasEdge(0,43), true);
        assertEquals(my.hasEdge(3,2), false);
    }

    @org.junit.Test
    public void readGraph() {
        my.addEdge(0,1);
        my.addEdge(0,43);
        my.addEdge(1,67);
        my.addEdge(1,32);
        my.addEdge(3,23);
        my.addEdge(2,43);
        my.saveGraph();
        assertEquals(my.getList(), my.readGraph());
    }

    @Test
    public void draw() {
        my.addEdge(0,1);
        my.addEdge(0,43);
        my.addEdge(1,67);
        my.addEdge(1,32);
        my.addEdge(3,23);
        my.addEdge(2,43);
        my.addEdge(0,213);
        my.addEdge(1,633);
        my.addEdge(1,92);
        my.addEdge(3,56);
        my.addEdge(4,23);
        my.addEdge(8, 1);
        my.addEdge(10,234);
        my.draw();
    }
}