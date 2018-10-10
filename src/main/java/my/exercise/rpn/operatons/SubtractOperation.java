package my.exercise.rpn.operatons;

public class SubtractOperation implements CalculatorOperation {
    private Double a;
    private Double b;

    public SubtractOperation (Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double calculate() {

        return b - a;    }
}
