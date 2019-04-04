import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Lifo<T> extends MyLinkedList implements Queue {

    public boolean add(Object o){
       boolean answer = super.add(o, 0);
        return answer;
    }

    @Override
    public boolean offer(Object o) {
        boolean answer = super.add(o, 0);
        return answer;
    }


    @Override
    public T remove() {
        T object = (T) super.get(0);
        if(object == null){
            throw new NoSuchElementException();
        }
        super.remove(0);
        return object;
    }


    @Override
    public T poll() {
        T object = (T) super.get(0);
        if(object == null){
            return null;
        }
        super.remove(0);
        return object;
    }

    @Override
    public T element() {
        return (T) super.get(0);
    }

    @Override
    public T peek() {
        T object = (T) super.get(0);
        if(object == null){
            return null;
        }
        return object;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
