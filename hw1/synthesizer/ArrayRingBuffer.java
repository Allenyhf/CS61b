
package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;
   // private int fillCount;
   // private int cap;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */

    public ArrayRingBuffer(int capacity) {
        //       Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount == capacity()) {
            throw new RuntimeException("Ring Buffer overflow");
        }

        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // Dequeue the first item. Don't forget to decrease fillCount and update
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T tmp = rb[first];
        first = (first + 1) % capacity;
        fillCount--;
        return tmp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // Return the first item. None of your instance variables should change.
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return rb[first];
    }
    /**
     * Return size of the buffer
     */
//    @Override
//    public int capacity() {
//        return capacity;
//    }

    /*
     * Return number of items currently in the buffer
     */
//    @Override
//    public int fillCount() {
//        return fillCount;
//    }



    // When you get to part 5, implement the needed code to support iteration.

    public Iterator<T> iterator() {
        return new ARBIterator<T>();
    }

    private class ARBIterator<T> implements Iterator<T> {
        private int ptr;
        public ARBIterator() {
            ptr = first;
        }

        @Override
        public boolean hasNext() {
            return (ptr != last);
        }

        @Override
        public T next() {
            T tmp = (T) rb[ptr];
            ptr = (ptr + 1) % capacity;
            return tmp;
        }
    }


    /**
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        ArrayRingBuffer<T> tobeCompared = (ArrayRingBuffer<T>) o;
        if (this.fillCount() != tobeCompared.fillCount()) {
            return false;
        }
        T ele1;
        int ptr = first;
        for (T ele2: tobeCompared) {
            if (ptr == last) {
                return false;
            }
            ele1 = rb[ptr];
            ptr = (ptr + 1) % capacity;
            if (!ele2.equals(ele1)) {
                return false;
            }
        }
        return true;
    }
*/

}

