package my.exercise.rpn;

/**
 * Enum for Arithmetic Operators with a abstract method to perform the Arithmetic operations
 */
public enum ArithmeticOperator {

    ADD("+"){
        @Override public double calculate(double a, double b){
            return a + b;
        }
    },
    SUBSTRACT("-"){
        @Override public double calculate(double a, double b){
            return a + b;
        }

    }, DIVIDE("/"){
        @Override public double calculate(double a, double b){
            return a / b;
        }

    }, MULTIPLE("*"){
        @Override public double calculate(double a, double b){
            return a * b;
        }
    };

    public abstract double calculate(double a, double b);

    public final String text;

    ArithmeticOperator(String text) {
        this.text = text;
    }

    @Override public String toString() {
        return text;
    }

    /**
     *
     * @param arithmeticOperator
     * @param a
     * @param b
     * @return
     */
    public double calculate(ArithmeticOperator arithmeticOperator, double a, double b)
    {
        return arithmeticOperator.calculate(a, b);
    }
}