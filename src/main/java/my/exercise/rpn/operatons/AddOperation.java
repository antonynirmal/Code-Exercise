package my.exercise.rpn.operatons;

public class AddOperation implements CalculatorOperation {

    private Double a;
    private Double b;

     public AddOperation(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double calculate() {
            return a + b;
    }
}
