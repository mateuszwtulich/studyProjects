import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyFloydWarshallTest {
    MyAdjacencyMatrix my = new MyAdjacencyMatrix(5);



    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void work() {
        my.addVertex(0, 4);
        my.addVertex(1,3);
        my.addVertex(2,5);
        my.addVertex(3, 6);
        my.addVertex(4,7);
        my.addVertex(5,8);

        my.addEdge(0,1,4);
        my.addEdge(1,3,7);
        my.addEdge(2,1,9);
        my.addEdge(4,5,2);
        my.addEdge(0,2,2);
        my.addEdge(2,3,4);
        my.addEdge(2,4,3);
        my.addEdge(3,5,43);

        my.draw();
        MyFloydWarshall floyd = new MyFloydWarshall(my.getMatrix());
        floyd.work();
    }

    @Test
    public void printResults() {
        my.addVertex(0, 4);
        my.addVertex(1,3);
        my.addVertex(2,5);
        my.addVertex(3, 6);
        my.addVertex(4,7);
        my.addVertex(5,8);

        my.addEdge(0,1,4);
        my.addEdge(1,3,7);
        my.addEdge(2,1,9);
        my.addEdge(4,5,2);
        my.addEdge(0,2,2);
        my.addEdge(2,3,4);
        my.addEdge(2,4,3);
        my.addEdge(3,5,43);

        MyFloydWarshall floyd = new MyFloydWarshall(my.getMatrix());
        floyd.work();
        floyd.printResults();
    }

    @Test
    public void getShortest() {
        my.addVertex(0, 4);
        my.addVertex(1,3);
        my.addVertex(2,5);
        my.addVertex(3, 6);
        my.addVertex(4,7);
        my.addVertex(5,8);

        my.addEdge(0,1,4);
        my.addEdge(1,3,7);
        my.addEdge(2,1,9);
        my.addEdge(4,5,2);
        my.addEdge(0,2,2);
        my.addEdge(2,3,4);
        my.addEdge(2,4,3);
        my.addEdge(3,5,43);

        MyFloydWarshall floyd = new MyFloydWarshall(my.getMatrix());
        floyd.work();

        assertEquals(7,floyd.getShortest(0,5));
        assertEquals(6,floyd.getShortest(0,3));
        assertEquals(9,floyd.getShortest(1,4));
        assertEquals(7,floyd.getShortest(3,4));
    }

    @Test
    public void getPosition() {
        my.addVertex(0, 4);
        my.addVertex(1,3);
        my.addVertex(2,5);
        my.addVertex(3, 6);
        my.addVertex(4,7);
        my.addVertex(5,8);

        my.addEdge(0,1,4);
        my.addEdge(1,3,7);
        my.addEdge(2,1,9);
        my.addEdge(4,5,2);
        my.addEdge(0,2,2);
        my.addEdge(2,3,4);
        my.addEdge(2,4,3);
        my.addEdge(3,5,43);
        my.draw();

        MyFloydWarshall floyd = new MyFloydWarshall(my.getMatrix());
        floyd.getPosition();
        floyd.work();

    }
}