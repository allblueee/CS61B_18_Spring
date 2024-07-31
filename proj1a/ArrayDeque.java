public class ArrayDeque<T> {
    public int capacity;
    public int size;
    public T[] List;
    private int start;
    private int end;

    public ArrayDeque() {
        capacity = 8;
        size = 0;
        List = (T []) new Object[capacity];
        start = 0;
        end = 0;
    }

    private void resize() {
        if(size + 1 == capacity){
            capacity *= 2;
        }

        if(capacity / size > 4){
            capacity /= 2;
        }

        T[] _List = (T []) new Object[capacity];
        System.arraycopy(List, start, _List, 0, size);
        start = 0;
        end = size;
        List = _List;
    }

    public void addFirst(T item){
        resize();
        List[start] = item;
        start = (start - 1) % capacity;
        size++;
    }

    public void addLast(T item){
        resize();
        List[end] = item;
        end = (end + 1) % capacity;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i < size; i++){
            System.out.print(List[(start + i) % capacity] + " ");
        }
    }

    public T removeFirst(){
        T temp = List[start];
        List[start] = null;
        start = (start + 1) % capacity;
        resize();
        return temp;
    }

    public T removeLast(){
        end = (end - 1) % capacity;
        T temp = List[end];
        resize();
        return temp;
    }

    public T get(int index){
        return List[(start + index) % capacity];
    }
}
