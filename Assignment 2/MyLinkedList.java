import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class Node {
        T data;
        Node next, prev;
        Node(T data) { this.data = data; }
    }

    private Node head, tail;
    private int size = 0;

    public void add(T item) {
        Node newNode = new Node(item);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        return temp.data;
    }

    public void removeFirst() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    public void sort() {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data.compareTo(j.data) > 0) {
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    public int size() { return size; }
    public void clear() { head = tail = null; size = 0; }
    public T getFirst() { return head.data; }
    public T getLast() { return tail.data; }
    public void addLast(T item) { add(item); }
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node curr = head;
            public boolean hasNext() { return curr != null; }
            public T next() {
                T d = curr.data;
                curr = curr.next;
                return d;
            }
        };
    }

    public void set(int index, T item) {}
    public void add(int index, T item) {}
    public void remove(int index) {}
    public void removeLast() {}
    public int indexOf(Object obj) { return -1; }
    public int lastIndexOf(Object obj) { return -1; }
    public boolean exists(Object obj) { return false; }
    public Object[] toArray() { return null; }
}