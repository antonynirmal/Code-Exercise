package my.exercise.rpn;

import com.sun.jmx.mbeanserver.Repository;

import java.util.Optional;
import java.util.Stack;

public class RepositoryHandler{

    private Stack<Object> objectStack;

    RepositoryHandler (){
        objectStack = new Stack<>();
    }

    public void setToRepository(Object object) throws RPNException {
        if(object != null)
            objectStack.push(object);
        else
            throw new RPNException("Object value is null");
    }

    public int getSize(){
        return objectStack.size();
    }

    public Object getFromRepository() {
        if (!this.objectStack.empty()) {
            objectStack.pop(); Object object = objectStack.peek();
            return object;
        }
        return null;
    }

    public void reset(){
        this.objectStack.clear();
    }
}