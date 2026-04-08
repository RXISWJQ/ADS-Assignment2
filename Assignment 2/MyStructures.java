class MyStack<T extends Comparable<T>> {
    MyArrayList<T> list = new MyArrayList<>();
    public void push(T item) { list.add(item); }
    public T pop() {
        T item = list.getLast();
        list.removeLast();
        return item;
    }
}

class MyQueue<T extends Comparable<T>> {
    MyLinkedList<T> list = new MyLinkedList<>();
    public void enqueue(T item) { list.addLast(item); }
    public T dequeue() {
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
}

class MyMinHeap<T extends Comparable<T>> {
    MyArrayList<T> list = new MyArrayList<>();
    public void insert(T item) {
        list.add(item);
        int i = list.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (list.get(i).compareTo(list.get(p)) < 0) {
                T temp = list.get(i);
                list.set(i, list.get(p));
                list.set(p, temp);
                i = p;
            } else break;
        }
    }
}