package my.exercise.rpn;

import my.exercise.rpn.operatons.*;

import java.text.NumberFormat;
import java.util.Scanner;

import static my.exercise.rpn.operatons.Operator.*;

/**
 * RPN Calculator
 */
public class Calculator {

    private RPNStack stack;
    private int position;

    Calculator() {
        position = 0;
        stack = new RPNStack();
    }

    private RPNStack getStack() {
        return stack;
    }

    //Calculate Reverse Polish Notation
    protected void invoker(String expression) throws RPNException {

        Scanner input = new Scanner(expression);
        String token;
        Double result=0.0;
        while (input.hasNext()) {
            position++;
            token = input.next();
            if (isOperand(token)) {
                stack.push(decimalFormat(Double.valueOf(token)));
            }
            if(token.equals(SQUARE.getOperator())){
                result=new SquareOperation(stack.pop()).calculate();
                stack.push(decimalFormat(result));
            }
            if(token.equals(UNDO.getOperator())){
                stack.undo();
            }
            if(token.equals(CLEAR.getOperator())){
                reset();
            }
            if (stack.getStack().size() > 1 && this.isOperator(token)) {

                switch(Operator.forValue(token)){
                    case ADD:
                        stack.push(decimalFormat(new AddOperation(stack.pop(), stack.pop()).calculate()));
                        break;
                    case SUBSTRACT:
                        stack.push(decimalFormat(new SubtractOperation(stack.pop(), stack.pop()).calculate()));
                        break;
                    case MULTIPLE:
                        stack.push(decimalFormat(new MultiplyOperation(stack.pop(), stack.pop()).calculate()));
                        break;
                    case DIVIDE:
                        if(stack.getStack().peek() != 0)
                                stack.push(decimalFormat(new DivideOperation(stack.pop(),
                                        stack.pop()).calculate()));
                            else
                            System.out.println("Undefined - Divide by 0");
                        break;
                    default:
                        System.out.println("Reached Default in Case:");
                }
            } else if (stack.getStack().size() <= 1 && this.isOperator(token)) {
                System.out.println("Token " + token + "(position: " + position + ") : insufficient parameters");
                break;
            }
        }
    }
    // To validate existence of Operator in string
    private boolean isOperator(String input) {
        return input.equals(ADD.getOperator()) || input.equals(SUBSTRACT.getOperator()) ||
                input.equals(MULTIPLE.getOperator()) || input.equals(DIVIDE.getOperator()) ;
    }
    // To validate existence of Operand in string
    private boolean isOperand(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    // Reset and clear stack
    private void reset(){
        position=0;
        stack.clear();
    }

    //enforcing 15 digit
    private Double decimalFormat(Double digit) throws RPNException{
        NumberFormat format = NumberFormat.getIntegerInstance();
        int STORE_MAX_DIGIT = 15;
        Double formatDigit;
        format.setMaximumFractionDigits(STORE_MAX_DIGIT);
        format.setMaximumIntegerDigits(STORE_MAX_DIGIT);
        formatDigit = Double.valueOf(format.format(digit));
        return formatDigit;
    }

    // Limiting decimal to 10 for display
    private Double outputFormat(Double digit) throws RPNException{
        int DISPLAY_MAX_DIGIT = 10;
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setMaximumFractionDigits(DISPLAY_MAX_DIGIT);
        if(digit - Double.valueOf(format.format(digit)) < 0.0000001){
            return Double.valueOf(format.format(digit));
        }
        return digit;
    }

    //Print the Stack with whitespace as delimiter.
    protected void output() {

        System.out.print("Stack: ");

            stack.getStack().forEach(e -> {
                try {
                    System.out.print(outputFormat(e) + "  ");
                } catch (RPNException e1) {
                    System.out.println("Something wrong with the number, this may be too large!");                }
            });

        System.out.print("\n");
    }
}