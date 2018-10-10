package my.exercise.rpn.operatons;

import java.util.Arrays;

public enum Operator {

    ADD("+"),
    SUBSTRACT("-"),
    DIVIDE("/"),
    MULTIPLE("*"),
    SQUARE("sqrt"),
    UNDO("undo"),
    CLEAR("clear");


    private final String operator;

    Operator(String op) {
        this.operator = op;
    }

    public  String getOperator() {
        return this.operator;
    }

    public static Operator forValue(String value) {

        return Arrays.stream(Operator.values()).filter(code -> code.getOperator().equals(value)).findFirst().orElse(null);

    }

}