package my.exercise.rpn;

import java.util.Stack;

public class RepositoryHandler{

    private final Stack<Object> objectStack;

    RepositoryHandler (){
        objectStack = new Stack<>();
    }

    void setToRepository(Object object) throws RPNException {
        if(object != null)
            objectStack.push(object);
        else
            throw new RPNException("Object value is null");
    }

    public int getSize(){
        return objectStack.size();
    }

    Object getFromRepository() {
        if (!this.objectStack.empty()) {
            objectStack.pop();
            return objectStack.size() == 0 ? null : objectStack.peek();
        }
        return null;
    }

    void reset(){
        this.objectStack.clear();
    }
}