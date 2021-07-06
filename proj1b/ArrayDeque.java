public class ArrayDeque<T> implements Deque<T> {

    private T[] arr;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        capacity = 8;
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private void resize(int cap) {
        T[] arr2 = (T[]) new Object[cap];
        //int start = (nextFirst == capacity-1) ? 0 : nextFirst+1;
        //int start = (nextFirst + 1) % capacity;
        int start = getStart();
        int sz = 0;
        while (sz < size) {
            arr2[sz] = arr[start];
            start = (start + 1) % capacity;
            ++sz;
        }
        capacity = cap;
        nextFirst = capacity - 1;
        nextLast = size;
        arr = arr2;
    }

    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }

        arr[nextFirst] = item;

        if (nextFirst == 0) {
            nextFirst = capacity - 1;
        } else {
            nextFirst--;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }

        arr[nextLast] = item;
        if (nextLast == capacity - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        size += 1;
    }
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    private   int getCapacity() {
        return capacity;
    }

    @Override
    public int size() {
        return size;
    }

    private int getStart() {
        return (nextFirst + 1) % capacity;
    }

    @Override
    public void printDeque() {
        int start = 0;

//        if(nextFirst == capacity - 1){
//            start = 0;
//        }else{
//            start = nextFirst + 1;
//        }

        start = getStart();
        int sz = 0;
        while (sz < size) {
            System.out.print(arr[start] + " ");
            start = (start + 1) % capacity;
            sz++;
        }
        System.out.println();

    }

    private void doShrink() {
        if (capacity > 16 && size * 4 < capacity && size * 4 > 16) {
            resize(size * 4);
        }
    }

    @Override
    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        //int first = (nextFirst==capacity-1) ? 0: nextFirst + 1;
//        int first = (nextFirst + 1) % capacity;
        int first = getStart();
        T tmp = arr[first];
        arr[first] = null;
        size -= 1;
        nextFirst = first;
//        if(capacity > 16 && size * 4 < capacity && size * 4 > 16){
//            resize(size * 4);
//        }
        doShrink();
        return tmp;
    }

    @Override
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        int last = (nextLast == 0) ? capacity - 1 : nextLast - 1;
        T tmp = arr[last];
        arr[last] = null;
        size -= 1;
        nextLast = last;
//        if(capacity > 16 && size * 4 < capacity && size * 4 > 16){
//            resize(size * 4);
//        }
        doShrink();
        return tmp;
    }

    @Override
    public T get(int index) {
//        int start = (nextFirst + 1) % capacity;
        int start = getStart();
        int pos = (start + index) % capacity;
        return arr[pos];
    }

}
