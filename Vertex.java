public class Vertex {
    private Object v;
    private int index;

    public Vertex(int index, Object v) {
        this.index = index;
        this.v = v;
    }

    public Vertex(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getV() {
        return v;
    }

    public void setV(Object v) {
        this.v = v;
    }

}
