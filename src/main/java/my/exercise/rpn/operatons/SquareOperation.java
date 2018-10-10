package my.exercise.rpn.operatons;

public class SquareOperation implements CalculatorOperation {
    private Double a;


    public SquareOperation (Double a) {
        this.a = a;

    }

    public Double calculate() {

        return Math.sqrt(a);
    }
}
