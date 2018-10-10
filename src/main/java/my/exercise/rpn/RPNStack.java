package my.exercise.rpn;

import my.exercise.rpn.repository.Repository;
import my.exercise.rpn.repository.RepositoryHandler;

import java.util.Stack;

/**
 * Stack Wrapper Class for Stack operations
 */
public class RPNStack {

    private Stack<Double> stack;
    private RepositoryHandler repositoryHandler;

    public RPNStack() {
        stack = new Stack<>();
        repositoryHandler = new RepositoryHandler();
    }

    public Stack<Double> getStack() {
        return stack;
    }

    // Push to Stack and persist using repository
    public void push(Double input) throws RPNException {
        this.stack.push(input);
        repositoryHandler.addStack(store());
    }

    // Stack pop
    public Double pop() {
            return stack.pop();
    }

    //Clone and persist for undo
    public Repository store() {
        return new Repository((Stack) stack.clone());
    }

    // To retrieve persisted repo
    void retrieve(Repository repo) {

        this.stack = repo.getStack();
    }

    // Undo method
    public void undo() throws RPNException {

        Repository repository = (Repository) repositoryHandler.getStack();
        if (repository != null)
            this.retrieve(repository);
        else {
            stack.clear();
            System.out.println("Stack is empty!");
        }
    }

    // To reset stack
    public void clear(){
        stack.clear();
        repositoryHandler.reset();
    }



}