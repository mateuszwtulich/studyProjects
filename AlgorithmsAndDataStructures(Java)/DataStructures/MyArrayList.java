import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T>{
    private int size = 10;
    private Object array[];

    public MyArrayList(){
        this.array = (T[])new Object[size];
    }

    public MyArrayList(int initialCapacity){
        this.size = initialCapacity;
        this.array = new Object[size];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    public class MyIterator<T> implements Iterator<T>{
        private final Iterator<T> it;
        private int index;

        public MyIterator(){
            it=null;
        }

        public MyIterator(Iterator it){
            this.it = it;
        }

        @Override
        public boolean hasNext() {
            boolean answer = false;
            if (array[index] != null) {
                    answer = true;
                }
            return answer;
        }

        @Override
        public T next() {
            T object;
            if(hasNext()){
                object = (T)array[index];
                index = index+1;
            }else{
                throw new NoSuchElementException();
            }
            return object;
        }
    }

    public int size(){
        int size =0;
            for(int i =1; i<this.size; i++){
                if(array[i-1] != null){
                    size = i;
                }
            }
        return size;
    }

    public int indexOf(T element){
        int index = -1;
        for(int i =0; i<array.length; i++){
            if(array[i] == element){
                index = i;
            }
        }
        return index;
    }

    public T set(int index, T element){
        T object = null;
        for(int i =0; i<array.length; i++){
            if(i==index){
                object = (T)array[i];
                array[i]= element;
            }
        }
        return object;
    }

    public boolean add(T element) {
        boolean answer = false;
        Object[] arr;
        int i = 0;

        while (array[i] != null) {
            i++;
        }
        if(((double)(i+1)/(double)size)>=0.9) {
            size += (0.1*size);
        }
        arr = (T[])new Object[size];

        for(int j=0; j<arr.length; j++) {
            if (i == j) {
                arr[j] = element;
                answer = true;
            }else if(j<i){
                arr[j] = array[j];
            }
        }
        this.array = arr;
        return answer;
    }

    public boolean add(int index, T element){
        boolean answer = false;
        Object[] arr;
        int i = 0;

        if(index<0||index>size()){
            throw new java.lang.IndexOutOfBoundsException();
        }

        while (array[i] != null) {
            i++;
        }
        if(((double)(i+1)/(double)size)>=0.9) {
            size += (0.1*size);
        }
        arr = (T[])new Object[size];

        for(int j=0; j<arr.length; j++){
            if(index>j){
                arr[j] = array[j];
            }else if(index == j){
                arr[j] = element;
                answer = true;
            }else if(index<j){
                arr[j] = array[j-1];
            }
        }
        this.array=arr;
        return answer;
    }

    public T remove(int index){
        T object = null;
        for(int i=0; i<array.length; i++){
            if(index ==i){
                object =(T) array[i];
                array[i] = null;
            }
        }
        if(index<0 || index> size){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return object;
    }

    public void clear(){
        for(int i=0; i<=size(); i++){
            array[i]= null;
        }
    }

    public boolean addAll(Collection<? extends T> c){
        boolean answer = false;
        Object[] arr;
        int i = 0;

        while (array[i] != null) {
            i++;
        }
        if(((double)(i+1)/(double)size)>=0.9) {
            size += (0.1*size);
        }

        if(c.size()> (size - i)){
            size+= c.size();
        }

        arr = (T[])new Object[size];

        for(int j=0; j<arr.length; j++) {
            if (i == j) {
                for(T object: c){
                    arr[j] = object;
                    j++;
                }
                answer = true;
            }else if(j<i){
                arr[j] = array[j];
            }
        }
        this.array = arr;
        return answer;
    }

    public boolean addAll(int index, Collection<? extends T> c){
        boolean answer = false;
        Object[] arr;
        int i = 0;

        while (array[i] != null) {
            i++;
        }
        if(((double)(i+1)/(double)size)>=0.9) {
            size += (0.1*size);
        }
        if(c.size()>= (size - i)){
            size+=c.size();
        }

        arr = (T[]) new Object[size];

        for(int j=0; j<arr.length; j++) {
            if (index == j) {
                for(T object: c){
                    arr[j] = object;
                    j++;
                }
                answer = true;
            }else if(index>j){
                arr[j] = array[j];
            }else if(index<j) {
                arr[j] = array[((j - 1) - c.size())];
            }
        }
        this.array = arr;
        return answer;
    }

    public T get(int index){
        T object = null;
        for(int i=0; i< array.length; i++){
            if(index ==i) {
                object = (T) array[i];
            }
        }
        if(index<0||index>size){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return object;
    }

}
