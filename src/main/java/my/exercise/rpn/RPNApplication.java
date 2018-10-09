package my.exercise.rpn;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Antony Niraml Raj
 * Command line based Reverse Polish Notation Calculator Left --> Right.
 * Accepts numbers 0 - 9 and operators +, - *, /, sqrt, undo and clear seperated by whitespace
 * and prints the stack result or error if any.
 */
public class RPNApplication {

    Stack<Double> stack;
    private RepositoryHandler repositoryHandler;
     //Counter for the Stack position.
    private int position;

    RPNApplication(){
        this.stack =  new Stack<>();
        this.repositoryHandler = new RepositoryHandler();
        position = 0;
    }

    Stack<Double> getStack() {
        return stack;
    }

    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }


    public static void main(String[] args) {
        String operator;
        RPNApplication fx = new RPNApplication();
        // System.out.println("Operator:"+fx.isOperator(operator));

        do {
            Scanner input = new Scanner(System.in);
            operator = input.nextLine();
            fx.calculateRPN(operator);
        }while(!operator.equalsIgnoreCase("exit"));
    }

    /**
     * Method accepts equation in String and performs the calculation and prints the output.
     * @param equation
     */
    public void calculateRPN(String equation) {
        Scanner input = new Scanner(equation);
        String token;
        try {
            while (input.hasNext()) {
                position++;
                if (input.hasNextInt() || input.hasNextDouble()) {
                    stack.push(Double.valueOf(input.next()));
                    repositoryHandler.setToRepository(store());
                } else {
                    token = input.next();
                    if (this.size() > 1 && this.isOperator(token)) {
                        if (token.equals(ArithmeticOperator.ADD.text))
                            stack.push(formatter(ArithmeticOperator.ADD.calculate(ArithmeticOperator.ADD, stack.pop(), stack.pop())));
                        if (token.equals(ArithmeticOperator.SUBSTRACT.text))
                            stack.push(formatter(ArithmeticOperator.SUBSTRACT.calculate(ArithmeticOperator.SUBSTRACT, -(stack.pop()), stack.pop())));
                        if (token.equals(ArithmeticOperator.MULTIPLE.text))
                            stack.push(formatter(ArithmeticOperator.MULTIPLE.calculate(ArithmeticOperator.MULTIPLE, stack.pop(), stack.pop())));
                        if (token.equals(ArithmeticOperator.DIVIDE.text)) {
                            Double top = stack.pop();
                            if (top == 0) {
                                System.out.println("Well, Any number divided by Zero is undefined!");
                            } else {
                                stack.push(formatter(ArithmeticOperator.DIVIDE.calculate(ArithmeticOperator.DIVIDE, stack.pop(), top)));
                            }
                        }
                        repositoryHandler.setToRepository(store());
                    } else if (this.size() <= 1 && this.isOperator(token)) {
                        System.out.println("Operator " + token + "(position: " + position + ") : insufficient parameters");
                        break;
                    }

                    if (token.equals(OtherOperator.SQUARE.text)) {
                        Double d = stack.pop();
                        try {
                            stack.push(formatter(Math.sqrt(d)));
                            repositoryHandler.setToRepository(this.store());
                        }catch(RPNException e){
                            System.out.println("Something not right with the numbers!");
                        }

                    }
                    if (token.equals(OtherOperator.UNDO.text)) {
                        Repository repository = (Repository) repositoryHandler.getFromRepository();
                        if (repository != null)
                            this.retrieve(repository);
                        else{
                            stack.clear();
                            System.out.println("Stack is empty!");
                        }
                    }
                    if (token.equals(OtherOperator.CLEAR.text)) {
                        stack.clear();
                        repositoryHandler.reset();
                        position = 0;
                    }
                }
            }
            this.print();
        }catch(RPNException r){
            System.out.println("Unknown error");
        }

    }

    /**
     * Returns the size of the stack
     * @return stack.size()
     */
    private int size(){
        return this.stack.size();
    }

    /**
     * This method validate the input string is a Arithmetic operator and returns the result in boolean format.
     * @param input
     * @return true or false
     */
    private boolean isOperator(String input) {
        return input.equals(ArithmeticOperator.ADD.text) || input.equals(ArithmeticOperator.SUBSTRACT.text) ||
                input.equals(ArithmeticOperator.MULTIPLE.text) || input.equals(ArithmeticOperator.DIVIDE.text);
    }

    /**
     * This method formats the fraction digits and limit to maximum of 15
     * @param digit
     * @return digit in Double
     */
    private Double formatter(Double digit) {
        NumberFormat format = NumberFormat.getIntegerInstance();
        int STORE_MAX_DIGIT = 15;
        double formatDigit;
        format.setMaximumFractionDigits(STORE_MAX_DIGIT);
        formatDigit = Double.valueOf(format.format(digit));
        return formatDigit;
    }

    /**
     * Method to check precision by reducing the fraction digits (with no loss of precision) used for display
     * @param digit
     * @return digit
     */
    private Double checkPrecision(Double digit) {
        int DISPLAY_MAX_DIGIT = 10;
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setMaximumFractionDigits(DISPLAY_MAX_DIGIT);
        if(digit - Double.valueOf(format.format(digit)) < 0.0000001){
            return Double.valueOf(format.format(digit));
        }
        return digit;
    }

    /**
     * Print the Stack with whitespace as delimiter.
     */
    private void print() throws RPNException{
        System.out.print("Stack: ");
        stack.forEach(E -> System.out.print(checkPrecision(E) + "  "));
        System.out.print("\n");
    }

    /**
     * Persist the stack
     * @return Repository instance
     */
    public Repository store(){
        return new Repository((Stack) stack.clone());
    }

    /**
     * Retrieve the persisted stack
     * @param repo
     */
    public void retrieve(Repository repo){

        stack = repo.getStack();
    }

    /**
     * Repository Class to perform the Stack persistence and retrieval - based on Memento Pattern
     */
    private class Repository{
        private Stack repoStack;

        public Repository(Stack stack){
            repoStack=stack;
        }

        public Stack getStack(){
            return repoStack;
        }
    }
}