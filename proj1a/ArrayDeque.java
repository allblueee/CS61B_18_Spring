public class ArrayDeque<T> {
    private int capacity;
    private int size;
    private T[] _list;
    private int start;
    private int end;

    public ArrayDeque() {
        capacity = 8;
        size = 0;
        _list = (T[]) new Object[capacity];
        start = 0;
        end = 0;
    }

    private void resize() {
        if (size + 1 == capacity) {
            capacity *= 2;
        }

        if (capacity > 4 * size) {
            capacity /= 2;
        }

        T[] list = (T[]) new Object[capacity];
        System.arraycopy(_list, start, list, 0, size);
        start = 0;
        end = size;
        _list = list;
    }

    public void addFirst(T item) {
        resize();
        _list[start] = item;
        start = (start - 1) % capacity;
        size++;
    }

    public void addLast(T item) {
        resize();
        _list[end] = item;
        end = (end + 1) % capacity;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(_list[(start + i) % capacity] + " ");
        }
    }

    public T removeFirst() {
        T temp = _list[start];
        _list[start] = null;
        start = (start + 1) % capacity;
        resize();
        return temp;
    }

    public T removeLast() {
        end = (end - 1) % capacity;
        T temp = _list[end];
        resize();
        return temp;
    }

    public T get(int index) {
        return _list[(start + index) % capacity];
    }
}
