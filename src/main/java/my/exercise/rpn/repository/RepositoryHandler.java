package my.exercise.rpn.repository;

import my.exercise.rpn.RPNException;

import java.util.Stack;

/**
 * Caretaker for the Repository
 */
public class RepositoryHandler{

    private final Stack<Object> objectStack;

    public RepositoryHandler(){
        objectStack = new Stack<>();
    }

    public void addStack(Object object) throws RPNException {
        if(object != null) {
            objectStack.push(object);
        }
        else
            throw new RPNException("Object value is null");
    }

    public Object getStack() {
        if (!this.objectStack.empty()) {
            objectStack.pop();
            return objectStack.size() == 0 ? null : objectStack.peek();
        }
        return null;
    }

    public void reset(){
        this.objectStack.clear();
    }
}