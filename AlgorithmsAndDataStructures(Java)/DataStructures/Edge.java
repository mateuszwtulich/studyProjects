public class Edge {
    private Object i;
    private Object j;
    private int w;

    public Edge(Object i, Object j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }

    public Object getJ() {
        return j;
    }

    public void setJ(Object j) {
        this.j = j;
    }

    public Object getI() {
        return i;
    }

    public void setI(Object i) {
        this.i = i;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

}
