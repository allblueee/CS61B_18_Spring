public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    public T getRecursiveHelper(Node p, int index) {
        if(index == 0) return p.item;
        return getRecursiveHelper(p.next, index - 1);
    }

    public class Node {
        public Node prev;
        public Node next;
        public T item;
        public Node(T item) {
            this.item = item;
        }
    }

    public void addFirst(T item) {
        Node firstNode = new Node(item);
        firstNode.next = sentinel.next;
        firstNode.prev = sentinel.next.prev;
        sentinel.next = firstNode;
        sentinel.prev = firstNode;
        size++;
    }

    public void addLast(T item) {
        Node lastNode = new Node(item);
        sentinel.prev.next = lastNode;
        lastNode.prev = sentinel.prev;
        lastNode.next = sentinel;
        sentinel.prev = lastNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        for(int i = 0; i < size; i++){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst(){
        Node delNode = sentinel.next;
        T item = delNode.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        delNode = null;
        size--;
        return item;
    }

    public T removeLast(){
        Node delNode = sentinel.prev;
        T item = delNode.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        delNode = null;
        size--;
        return item;
    }

    public T get(int index){
        Node p = sentinel.next;
        for(int i = 0; i <= index; i++){
            p = p.next;
        }
        return p.item;
    }
}
