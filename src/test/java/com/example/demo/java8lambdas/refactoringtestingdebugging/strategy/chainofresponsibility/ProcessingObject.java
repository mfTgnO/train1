package com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-15 16:17
 * @Description:
 */
/*
 * 8.2.4. Chain of responsibility
 *
 * The chain of responsibility pattern is a common solution to create a chain of processing objects
 * (such as a chain of operations). One processing object may do some work and pass the result to
 * another object, which then also does some work and passes it on to yet another processing
 * object, and so on.
 * Generally, this pattern is implemented by defining an abstract class representing a processing
 * object that defines a field to keep track of a successor. Once it has finished its work, the
 * processing object hands over its work to its successor. In code it looks like this:
 * */
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T t = handleWork(input);
        if (successor != null) {
            return successor.handle(t);
        }
        return t;
    }

    abstract protected T handleWork(T input);
}
