package my.exercise.rpn;

public enum OtherOperator {

    SQUARE("sqrt"), UNDO("undo"), CLEAR("clear");

    public final String text;

    OtherOperator(String text) {
        this.text = text;
    }
}
