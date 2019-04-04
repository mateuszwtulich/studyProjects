import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDijkstra2Test {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void searchSPFrom() {
        MyAdjacencyList adj = new MyAdjacencyList(4 );
        adj.addEdge(0,1,3);
        adj.addEdge(0,2,2);
        adj.addEdge(0,3,7);
        adj.addEdge(1,3,4);
        adj.addEdge(2,3,6);

        adj.addVertex(0);
        adj.addVertex(1);
        adj.addVertex(2);
        adj.addVertex(3);

        MyDijkstra2 my = new MyDijkstra2(adj);
        my.searchSPFrom(0);
        my.printInfo(0);
    }

    @Test
    public void printInfo() {
    }
}