package my.exercise.rpn;

import java.util.Stack;

public class RPNStack {
    Stack<Double> stack = new Stack<>();

    public RPNStack() {
        this.store();
    }

    public Double getStack() {
        if (!this.stack.empty()) {
            return stack.pop();
        }
        return null;
    }

    public void setStack(double stack) {
        this.stack.push(stack);
    }

    void change(Stack stack) {
        this.store();
    }

    public Repository store() {
        return new Repository(this.stack);
    }

    void retrieve(Repository repo) {

        this.stack = repo.getStack();
    }

    private class Repository {
        private Stack stack;

        Repository(Stack stack) {
            this.stack = stack;
        }

        public Stack getStack() {
            return this.stack;
        }
    }
}