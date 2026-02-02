import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests para VectorStack
 */
public class VectorStackTest {
    
    private IStack<Integer> stack;
    
    @Before
    public void setUp() {
        stack = new VectorStack<>();
    }
    
    @Test
    public void testPushAndPop() {
        stack.push(5);
        stack.push(10);
        assertEquals(10, (int) stack.pop());
        assertEquals(5, (int) stack.pop());
    }
    
    @Test
    public void testPeek() {
        stack.push(7);
        assertEquals(7, (int) stack.peek());
        assertEquals(7, (int) stack.peek()); // No debe quitar elemento
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
    
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }
    
    @Test
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
    }
    
    @Test(expected = RuntimeException.class)
    public void testPopEmpty() {
        stack.pop();
    }
    
    @Test(expected = RuntimeException.class)
    public void testPeekEmpty() {
        stack.peek();
    }
}
