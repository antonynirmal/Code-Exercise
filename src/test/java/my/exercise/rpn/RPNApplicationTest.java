package my.exercise.rpn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Antony Nirmal Raj
 *
 * Test class for verifying the Revere Polish Notation equations
 * (based on the example from the programming exercise document)
 */
public class RPNApplicationTest {

    @Test
    public void AddToStack() {
        RPNApplication tester = new RPNApplication(); // MyClass is tested

        tester.calculateRPN("5 2");
        String out = "";
            for (Double E : tester.getStack())
                out = out + E +" ";

        // assert statements
        assertEquals("5.0 2.0".trim(), out.trim(), "AddToStack: ");
    }

    @Test
    public void AdditionOfTwoNumbers() {
        RPNApplication tester = new RPNApplication(); // MyClass is tested

       tester.calculateRPN("1 1 +");
       double d = tester.stack.peek();
        // assert statements
        assertEquals(0, d, 2.0);
    }

    @Test
    public void AdditionOfThreeNumbers() {
        RPNApplication tester = new RPNApplication(); // MyClass is tested

        tester.calculateRPN("1 2 3 + +");
        double d = tester.stack.peek();
        // assert statements
        assertEquals(0, d, 6.0);
    }

    @Test
    public void SquareRootOfTwo() {
        RPNApplication tester = new RPNApplication(); // MyClass is tested

        tester.calculateRPN("2 sqrt");
        double d = tester.stack.peek();
        // assert statements
        System.out.println("Result: " + d );
        assertEquals(0, d, 1.4142135623730951);
    }

    @Test
    public void InsufficientParameter() {
        RPNApplication tester = new RPNApplication(); // MyClass is tested

        tester.calculateRPN("1 2 3 * 5 + * * 6 5");
        double d = tester.stack.peek();
        // assert statements
        assertEquals(11.0, d, "operator * (position: 15): insufficient parameters");
    }
}