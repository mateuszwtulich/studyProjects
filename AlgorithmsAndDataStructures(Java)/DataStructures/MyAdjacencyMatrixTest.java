import org.junit.Test;

import static org.junit.Assert.*;

public class MyAdjacencyMatrixTest {
    MyAdjacencyMatrix my = new MyAdjacencyMatrix(4);

    @org.junit.Test
    public void addEdge() {
        my.addEdge(1,1);
        my.addEdge(0,1);
        my.addEdge(1,0);
        my.addEdge(1,3);
        my.addEdge(3,1);
        my.addEdge(2,1);
        my.addEdge(4,5);
        assertEquals(my.hasEdge(1,1), true);
        assertEquals(my.hasEdge(1,3), true);
        assertEquals(my.hasEdge(2,1), true);
        assertEquals(my.hasEdge(0,1), true);
    }

    @org.junit.Test
    public void removeEdge() {
        my.addEdge(1,1);
        my.addEdge(0,1);
        my.addEdge(1,0);
        my.addEdge(1,3);
        my.addEdge(3,1);
        my.addEdge(2,1);
        my.removeEdge(1,1);
        my.removeEdge(1,0);
        my.removeEdge(1,3);
        assertEquals(my.hasEdge(1,1),false);
        assertEquals(my.hasEdge(1,0),false);
        assertEquals(my.hasEdge(3,1),true);
        assertEquals(my.hasEdge(1,3),false);
    }

    @org.junit.Test
    public void hasEdge() {
        my.addEdge(1,1);
        my.addEdge(0,1);
        my.addEdge(1,0);
        my.addEdge(1,3);
        my.addEdge(3,1);
        my.addEdge(2,1);
        assertEquals(my.hasEdge(1,1), true);
        assertEquals(my.hasEdge(1,3), true);
        assertEquals(my.hasEdge(2,1), true);
        assertEquals(my.hasEdge(0,1), true);
        assertEquals(my.hasEdge(0,0), false);
    }

    @org.junit.Test
    public void readGraph() {
        my.addEdge(1,1);
        my.addEdge(0,1);
        my.addEdge(1,0);
        my.addEdge(1,3);
        my.addEdge(3,1);
        my.addEdge(2,1);
        my.saveGraph();
        assertEquals(my.getMatrix(), my.readGraph());
    }

    @Test
    public void draw() {
        my.addEdge(1,1);
        my.addEdge(0,1);
        my.addEdge(1,0);
        my.addEdge(1,3);
        my.addEdge(3,1);
        my.addEdge(2,1);
        my.addEdge(2,1);
        my.addEdge(4,5);
        my.addEdge(7,2);
        my.removeEdge(7,2);
        my.draw();
    }
}