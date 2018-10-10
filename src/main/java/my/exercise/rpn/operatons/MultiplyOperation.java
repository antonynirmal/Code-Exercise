package my.exercise.rpn.operatons;

public class MultiplyOperation implements CalculatorOperation {
    private Double a;
    private Double b;

    public MultiplyOperation (Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double calculate() {

        return b * a;    }
}
