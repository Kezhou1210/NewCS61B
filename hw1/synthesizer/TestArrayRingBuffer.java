package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        Iterator<Integer> arbIterator = arb.iterator();
        arb.enqueue(3);
        arb.enqueue(10);
        arb.enqueue(15);
        arb.enqueue(20);
        arb.enqueue(25);
        assertTrue(arbIterator.hasNext());
        arb.dequeue();
        arb.dequeue();
        assertEquals(15, (int)arbIterator.next());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
