import java.io.*;
import java.util.*;

public class MyAdjacencyList {

    private int size;
    private List<Integer>[] list;
    private File file = new File("saveThis");

    public MyAdjacencyList(int size) {
        this.size = size;
        list = (List<Integer>[]) new List[size];
        for (int i = 0; i < size; i++)
            list[i] = new ArrayList<Integer>();
    }

    private void ensureCapacity(int inner){
        List<Integer>[] list = (List<Integer>[]) new List[inner+1];
        for (int i = 0; i < inner+1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int j = 0; j < this.list.length; j++) {
            for (Integer in : this.list[j]) {
                    list[j].add(in);
            }
        }
        size = inner+1;
        this.list = list;
    }

    public void addEdge(int i, int j) {
        if(i>=size){
            ensureCapacity(i);
        }
        list[i].add(j);
    }

    public void removeEdge(int i, int j) {
        Iterator<Integer> it = list[i].iterator();
        while (it.hasNext()) {
            if (it.next() == j) {
                it.remove();
                return;
            }
        }
    }

    public boolean hasEdge(int i, int j) {
        return list[i].contains(j);
    }

    public List<Integer> outEdges(int i) {
        return list[i];
    }

    public List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) {
            if (list[j].contains(i))
                edges.add(j);
        }
        return edges;
    }

    public void saveGraph(){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for(int i=0; i<list.length; i++){
                for(int j =0; j<list[i].size(); j++){
                        writer.format("%d,", list[i].get(j));
                }
                writer.format("/");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer>[] readGraph() {
        List<Integer>[] list = (List<Integer>[]) new List[size];
        int j = 0;

        for (int i = 0; i < size; i++)
            list[i] = new ArrayList<Integer>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String string = reader.readLine();
            String[] str = string.split("/");

            for (String line : str) {
                String[] s = line.split(",");
                for (String digit : s) {
                    list[j].add(Integer.parseInt(digit));
                }
                j++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Integer>[] getList(){
        return list;
    }

    public void draw() {
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + " ");
            for (Integer in : list[i]) {
                System.out.print(in + " ");
            }
            System.out.print("\n");
        }
    }

}
