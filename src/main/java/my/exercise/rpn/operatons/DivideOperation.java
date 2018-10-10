package my.exercise.rpn.operatons;

public class DivideOperation implements CalculatorOperation {

    private Double a;
    private Double b;

    public DivideOperation (Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double calculate() {

        return b / a;    }
}
