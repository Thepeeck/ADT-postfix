import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests para PostfixCalculator
 */
public class PostfixCalculatorTest {
    
    private IPostfixCalculator calculator;
    
    @Before
    public void setUp() {
        calculator = new PostfixCalculator();
    }
    
    @Test
    public void testSimpleAddition() throws Exception {
        int result = calculator.evaluate("5 3 +");
        assertEquals(8, result);
    }
    
    @Test
    public void testSimpleSubtraction() throws Exception {
        int result = calculator.evaluate("10 3 -");
        assertEquals(7, result);
    }
    
    @Test
    public void testSimpleMultiplication() throws Exception {
        int result = calculator.evaluate("4 5 *");
        assertEquals(20, result);
    }
    
    @Test
    public void testSimpleDivision() throws Exception {
        int result = calculator.evaluate("20 4 /");
        assertEquals(5, result);
    }
    
    @Test
    public void testAssignmentExample() throws Exception {
        // ((1 + 2) * 4) + 3 = 15
        int result = calculator.evaluate("1 2 + 4 * 3 +");
        assertEquals(15, result);
    }
    
    @Test
    public void testSecondExample() throws Exception {
        // 6 * (2 + 3) = 30
        int result = calculator.evaluate("6 2 3 + *");
        assertEquals(30, result);
    }
    
    @Test(expected = Exception.class)
    public void testDivisionByZero() throws Exception {
        calculator.evaluate("5 0 /");
    }
    
    @Test(expected = Exception.class)
    public void testInsufficientOperands() throws Exception {
        calculator.evaluate("5 +");
    }
    
    @Test(expected = Exception.class)
    public void testInvalidToken() throws Exception {
        calculator.evaluate("5 abc +");
    }
    
    @Test(expected = Exception.class)
    public void testTooManyOperands() throws Exception {
        calculator.evaluate("5 3 2 +");
    }
}
