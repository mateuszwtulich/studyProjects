public class MyFloydWarshall {
    private int[][] matrix;
    private int[][] position;
    private int w;

    MyFloydWarshall(int[][] matrix){
        this.matrix = matrix;
        position = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                if(matrix[i][j]!= Integer.MAX_VALUE && matrix[i][j]!=0) {
                    position[i][j] = i;
                }else
                    position[i][j] = -1;
            }
        }
    }

    public void work(){

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if ((matrix[j][i] == Integer.MAX_VALUE) || (matrix[i][k] == Integer.MAX_VALUE))continue;
                        w = matrix[j][i] + matrix[i][k];
                    if (matrix[j][k] > w) {
                        matrix[j][k] = w;
                        position[j][k] = position[i][k];
                    }
                }
            }
        }
    }

    public void printResults(){

        for(int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("distance[" + i + "," + j + "] = ");
                if (matrix[i][j] == Integer.MAX_VALUE) System.out.print("NO PATH");
                else System.out.print(matrix[i][j]);
                System.out.println();
            }
        }
    }

    public void getPosition(){
        for (int i = 0; i < position.length ; i++) {
            for (int j = 0; j < position.length ; j++) {
                System.out.print(position[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printPath (int i, int j)
    {
        if(i == j) System.out.print(i + " ");
        else if(position[i][j] == -1) System.out.print("NO PATH");
        else
        {
            printPath(i,position[i][j]);
            System.out.print( j + " ");
        }
    }

    public void printAll() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(i + "-" + j + " : ");
                printPath(i, j);
                System.out.println();

            }
        }
    }

    public int getShortest(int i, int j){
        return matrix[i][j];
    }
}
