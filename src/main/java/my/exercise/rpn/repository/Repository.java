package my.exercise.rpn.repository;

import java.util.Stack;

/**
 * Repository to perform undo operation based on Memento Pattern
 */
public class Repository {
    public Stack<Double> repoStack;

    public Repository(Stack stack) {
        this.repoStack = stack;
    }

    public Stack getStack() {
        return this.repoStack;
    }
}