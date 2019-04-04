import java.util.ArrayList;
import java.io.*;
public class MyAdjacencyMatrix {
    private int size;
    private boolean[][] matrix;
    private File file = new File("saveThis");

    public MyAdjacencyMatrix(int size) {
        this.size = size;
        matrix = new boolean[size][size];
    }

    private void ensureCapacity(int inner) {
        boolean [][] mat = new boolean[inner+1][inner+1];
        for(int i =0; i<size; i++){
            for(int j=0; j<size; j++){
                mat[i][j] = matrix[i][j];
            }
        }
        size = inner+1;
        matrix = mat;
    }

    public void addEdge(int i, int j) {
        if(i>=size||j>=size){
            if(i>j) {
                ensureCapacity(i);
            }else
                ensureCapacity(j);
        }
        matrix[i][j] = true;
    }

    public void removeEdge(int i, int j) {
        matrix[i][j] = false;
    }

    public boolean hasEdge(int i, int j) {
        return matrix[i][j];
    }

    public ArrayList<Integer> outEdges(int i) {
        ArrayList<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++)
            if (matrix[i][j]) edges.add(j);
        return edges;
    }

    public ArrayList<Integer> inEdges(int i) {
        ArrayList<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++)
            if (matrix[j][i]) edges.add(j);
        return edges;
    }

    public void saveGraph(){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for(int i=0; i<size; i++){
                for(int j =0; j<size; j++){
                    if(matrix[i][j]==true){
                        writer.format("%d,", 1);
                    }else
                    writer.format("%d,",0);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean[][] readGraph(){
        boolean[][] m = new boolean[size][size];
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String string = reader.readLine();
            String[] str = string.split(",");
            int k=0;

            for(int i=0; i<size; i++) {
                for (int j = 0; j < size; j++) {
                    if (str[k].equals("1")) {
                        m[i][j] = true;
                    } else
                        m[i][j] = false;
                    k++;
                }
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return m;
    }

    public void draw(){
        for(int i = 0; i< size; i++){
            for(int j =0; j<size; j++){

                if(matrix[i][j]==true) {
                    System.out.print(1 + " ");
                }else
                    System.out.print(0+ " ");
            }
            System.out.print("\n");
        }
    }

    public boolean[][] getMatrix(){
        return matrix;
    }
}