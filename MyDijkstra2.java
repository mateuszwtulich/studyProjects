import java.util.*;

public class MyDijkstra2{
    MyAdjacencyList myList;
    ArrayList<Integer> V = new ArrayList<Integer>();
    ArrayList<Edge> set = new ArrayList<Edge>();
    int[] dist;
    int[] pos;

    MyDijkstra2(MyAdjacencyList myList) {
        this.myList = myList;

        for(int i =0; i < myList.getList().length; i++){
            V.add(i);
        }
        dist = new int[myList.getList().length];
        pos = new int[myList.getList().length];
    }

    private int addingEdges(int indexOfV){
        Edge minW = new Edge(0,0, Integer.MAX_VALUE);

        ArrayList<Edge> list = myList.getArray(indexOfV);
        set.addAll(list);
        int first = minW.getW();

        for(Object edge: set) {
            int second = ((Edge) edge).getW();
            if(first>= second)
                minW = (Edge)edge;
        }

        dist[indexOfV] = minW.getW();
        pos[indexOfV] = (int)minW.getI();
        set.remove(minW);
        return (int) minW.getJ();
    }



    public void searchSPFrom(int index){
        while(V!=null) {
            V.remove(index);
            index = addingEdges(index);
        }
    }

    public void printInfo(int index){
        for (int i = 0; i < dist.length; i++) {
            System.out.println("From " + index + " to " + i + " the distance equals: " + dist[i]);
        }
    }
}
