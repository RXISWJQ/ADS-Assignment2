public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.sort();
        for (Integer i : list) System.out.print(i + " ");
        System.out.println();

        MyList<Integer> linked = new MyLinkedList<>();
        linked.add(10);
        linked.add(5);
        linked.removeFirst();
        for (Integer i : linked) System.out.print(i + " ");
        System.out.println();

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(50);
        heap.insert(10);
        heap.insert(30);
        System.out.println(heap.list.get(0));
    }
}