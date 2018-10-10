package my.exercise.rpn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expression;
        Calculator rpn = new Calculator();
        do {
            Scanner input = new Scanner(System.in);
            expression = input.nextLine();
            try {
                rpn.invoker(expression);
                rpn.output();
            } catch (RPNException e) {
                e.printStackTrace();
            }
        }while(!expression.equalsIgnoreCase("exit"));
    }
}
