package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Allen You
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue_Dequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);

        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);

        int actual = arb.dequeue();
        assertEquals(1, actual);
        actual = arb.dequeue();
        assertEquals(2, actual);
        actual = arb.dequeue();
        assertEquals(3, actual);
    }

    @Test
    public void testFillcount() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(0, arb.fillCount());
        arb.enqueue(1);
        assertEquals(1, arb.fillCount());
        arb.enqueue(2);
        assertEquals(2, arb.fillCount());
        arb.dequeue();
        assertEquals(1, arb.fillCount());
    }

    @Test
    public void testCapacity() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(10, arb.capacity());
    }

    @Test
    public void testPeek() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(11);
        arb.enqueue(1);
        assertEquals(1, (int) arb.peek());
        arb.enqueue(2);
        assertEquals(1, (int) arb.peek());
        arb.enqueue(3);
        arb.dequeue();
        arb.dequeue();
        assertEquals(3, (int) arb.peek());
    }

    @Test
    public void testIterable() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(6);
        arb.enqueue(-1);
        arb.enqueue(0);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(5);
        int i= 1;
        for (int ele : arb) {
            assertEquals(i, ele);
            i++;
        }

    }

    public static void testOverflow() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(1);
        arb.enqueue(1);
        arb.enqueue(2);
    }


    public static void testUnderflow() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        arb.enqueue(1);
        arb.dequeue();
        arb.dequeue();
    }

    /**
    @Test
    public void testEquals() {
        ArrayRingBuffer<Integer> arb1 = new ArrayRingBuffer<>(5);
        Integer num = 0;
        assertEquals(false, arb1.equals(num));
        assertEquals(false, arb1.equals(null));

        ArrayRingBuffer<Integer> arb2 = new ArrayRingBuffer<>(5);
        boolean actual = arb1.equals(arb2);
        assertEquals(true, actual);

        arb1.enqueue(1);
        arb2.enqueue(1);
        arb1.enqueue(2);
        arb2.enqueue(2);
        actual = arb1.equals(arb2);
        assertEquals(true, actual);

        arb1.enqueue(4);
        arb2.enqueue(3);
        actual = arb1.equals(arb2);
        assertEquals(false, actual);

        arb1.dequeue();
        arb2.dequeue();
        arb1.dequeue();
        arb2.dequeue();
        arb1.dequeue();
        arb2.dequeue();
        arb1.enqueue(1);
        arb1.enqueue(2);
        arb1.dequeue();
        arb2.enqueue(2);
        actual = arb1.equals(arb2);
        assertEquals(true, actual);
    }
*/


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
       // testOverflow();
       // testUnderflow();
    }
} 
