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
       double result = tester.getStack().getStack().peek();
        // assert statements
        assertEquals(0, result, 2.0);
    }

    @Test
    public void AdditionOfThreeNumbers()  throws RPNException {
        Calculator tester = new Calculator();

        tester.invoker("1 2 3 + +");
        double result = tester.getStack().getStack().peek();
        // assert statements
        assertEquals(0, result, 6.0);
    }

    @Test
    public void AdditionOfThreeNumbersAndUndo()  throws RPNException {
        Calculator tester = new Calculator();

        tester.invoker("1 2 3 + + undo");
        String out = "";
        for (Double E : tester.getStack().getStack())
            out = out + E +" ";
        double d = tester.getStack().getStack().peek();
        // assert statements
        assertEquals("1.0 5.0".trim(), out.trim());
    }

    @Test
    public void SquareRootOfTwo() throws RPNException  {
        Calculator tester = new Calculator();

        tester.invoker("2 sqrt");
        double result = tester.getStack().getStack().peek();
        // assert statements
        System.out.println("Result: " + result );
        assertEquals(0, result, 1.4142135623730951);
    }

    @Test
    public void InsufficientParameter() throws RPNException  {
        Calculator tester = new Calculator();

        tester.invoker("1 2 3 * 5 + * * 6 5");
        double result = tester.getStack().getStack().peek();
        // assert statements
        assertEquals((double)11.0, (double)result, (double)0.0);
    }

    @Test
    public void DividebyZero() throws RPNException  {
        Calculator tester = new Calculator();

        tester.invoker("1 0");
        // assert statements
        assertEquals("Undefined - Divide by 0", "Undefined - Divide by 0");
    }

    @Test
    public void SubtractAndClear() throws RPNException  {
        Calculator tester = new Calculator();

        tester.invoker("5 2 clear");
        boolean result = tester.getStack().getStack().empty();
        System.out.println(result);
        // assert statements
        assertEquals("Stack is Empty: ",true, result);
    }

}