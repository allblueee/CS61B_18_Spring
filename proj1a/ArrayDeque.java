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

        boolean flag = false;

        int origin_capacity = capacity;

        if (size + 1 == capacity) {
            capacity *= 2;
            flag = true;
        }

        if (capacity > 4 * size) {
            capacity /= 2;
            flag = true;
        }

        if(flag) {
            T[] list = (T[]) new Object[capacity];

            if(end >= start){
                System.arraycopy(_list, start, list, 0, end - start);
            } else {
                System.arraycopy(_list, start, list, 0, origin_capacity - start);
                System.arraycopy(_list, 0, list, origin_capacity - start, end);
            }

            start = 0;
            end = size;
            _list = list;
        }
    }

    public void addFirst(T item) {
        start = (start - 1 + capacity) % capacity;
        _list[start] = item;
        size++;
        resize();
    }

    public void addLast(T item) {
        _list[end] = item;
        end = (end + 1 + capacity) % capacity;
        size++;
        resize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(_list[(start + i + capacity) % capacity] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) return null;

        T temp = _list[start];
        _list[start] = null;
        start = (start + 1 + capacity) % capacity;

        size--;

        resize();
        return temp;
    }

    public T removeLast() {
        if (size == 0) return null;

        end = (end - 1 + capacity) % capacity;
        T temp = _list[end];

        size--;

        resize();
        return temp;
    }

    public T get(int index) {
        return _list[(start + index + capacity) % capacity];
    }
}
