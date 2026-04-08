import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr = new Object[5];
    private int size = 0;

    public void add(T item) {
        if (size == arr.length) {
            Object[] newArr = new Object[arr.length * 2];
            for (int i = 0; i < size; i++) newArr[i] = arr[i];
            arr = newArr;
        }
        arr[size++] = item;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) arr[i] = arr[i + 1];
        size--;
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (((T) arr[i]).compareTo((T) arr[j]) > 0) {
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public int size() { return size; }
    public boolean exists(Object obj) { return indexOf(obj) != -1; }
    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) if (arr[i].equals(obj)) return i;
        return -1;
    }

    public void clear() { size = 0; }
    public Object[] toArray() { return arr; }
    public void set(int index, T item) { arr[index] = item; }
    public void addFirst(T item) { add(0, item); }
    public void addLast(T item) { add(item); }
    public T getFirst() { return get(0); }
    public T getLast() { return get(size - 1); }
    public void removeFirst() { remove(0); }
    public void removeLast() { remove(size - 1); }
    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) if (arr[i].equals(obj)) return i;
        return -1;
    }
    public void add(int index, T item) {
        if (size == arr.length) { /* resize logic */ }
        for (int i = size; i > index; i--) arr[i] = arr[i - 1];
        arr[index] = item;
        size++;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            public T next() { return (T) arr[cursor++]; }
        };
    }
}