package my.exercise.rpn.repository;

import java.util.Stack;

public class Repository {
    public Stack<Double> repoStack;

    public Repository(Stack stack) {
        this.repoStack = stack;
    }

    public Stack getStack() {
        return this.repoStack;
    }
}