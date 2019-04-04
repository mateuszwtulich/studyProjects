import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private int size;
    private Node head;

    private class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            next = null;
            this.data = data;
        }

        public Node(T data, Node next) {
            this.next = next;
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public int size(){
        return size;
    }

    public int indexOf(T element){
        Node current = null;
        int index =-1;
        if (head != null) {
            current = head.getNext();
            while(current.getNext() != null){
                index++;
                if (current.getNext() == element) {
                    return index;
                }
                current = current.getNext();
            }
        }
        return index;
    }

    public boolean add(T data) {
        boolean answer = false;

        if (head == null) {
            head = new Node(data);
        }

        Node next = new Node(data);
        Node current = head;

        if (current != null) {

            while (current.getNext() != null) {
                current = current.getNext();
            }
            answer = true;
            current.setNext(next);
        }

        size++;
        return answer;
    }
    public boolean add(T data, int index) {
        boolean answer = false;

        if (head == null) {
            head = new Node(data);
        }

        Node next = new Node(data);
        Node current = head;

        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null ; i++) {
                current = current.getNext();
                answer = true;
            }
        }

        next.setNext(current.getNext());

        current.setNext(next);
        size++;

        return answer;
    }

    public boolean remove(int index) {

        if (index < 0 || index > size())
            return false;

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;

                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());

            size--;
            return true;

        }
        return false;
    }

    public Object get(int index) {

        if (index < 0 || index>size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }
        return current;

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    private class MyIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

}

