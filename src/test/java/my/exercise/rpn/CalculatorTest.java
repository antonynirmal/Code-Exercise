package my.exercise.rpn;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import org.junit.jupiter.api.Test;

/**
 * @author Antony Nirmal Raj
 *
 * Test class for verifying the Revere Polish Notation equations
 * (based on the example from the programming exercise document)
 */
public class CalculatorTest {

    @Test
    public void AddToStack() throws RPNException {
        Calculator tester = new Calculator();

        tester.invoker("5 2");
        String out = "";
            for (Double E : tester.getStack().getStack())
                out = out + E +" ";

        // assert statements
        assertEquals("5.0 2.0".trim(), out.trim());
    }

    @Test
    public void AdditionOfTwoNumbers()  throws RPNException {
        Calculator tester = new Calculator();

       tester.invoker("1 1 +");
       double d = tester.stack.getStack().peek();
        // assert statements
        assertEquals(0, d, 2.0);
    }

    @Test
    public void AdditionOfThreeNumbers()  throws RPNException {
        Calculator tester = new Calculator();

        tester.invoker("1 2 3 + +");
        double d = tester.stack.getStack().peek();
        // assert statements
        assertEquals(0, d, 6.0);
    }

    @Test
    public void SquareRootOfTwo() throws RPNException  {
        Calculator tester = new Calculator();

        tester.invoker("2 sqrt");
        double d = tester.stack.getStack().peek();
        // assert statements
        System.out.println("Result: " + d );
        assertEquals(0, d, 1.4142135623730951);
    }

    @Test
    public void InsufficientParameter() throws RPNException  {
        Calculator tester = new Calculator();

        tester.invoker("1 2 3 * 5 + * * 6 5");
        double d = tester.stack.getStack().peek();
        // assert statements
        assertEquals((double)11.0, (double)d, (double)0.0);
    }
}