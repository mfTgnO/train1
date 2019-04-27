package com.example.demo.java8lambdas.lambdaexpressions;

import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * @Package: com.example.demo.java8lambdas.lambdaexpressions
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 17:07
 * @Description:
 */
public class WritingLambdaExpressions {
    /*
     * shows how it’s possible to have a lambda expression with no arguments at all. You
     * can use an empty pair of parentheses, (), to signify that there are no arguments. This is
     * a lambda expression implementing Runnable, whose only method, run, takes no argu‐
     * ments and is a void return type.
     * */
    @Test
    public void test1() {
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();
    }

    /*
    * we have only one argument to the lambda expression, which lets us leave out the
    * parentheses around the arguments. This is actually the same form that we used in
    * Example 2-2.
    * */
    @Test
    public void test2() {
        ActionListener oneArgument = event -> System.out.println("button clicked");
    }

    /*
    * Instead of the body of the lambda expression being just an expression, in it’s a full
    * block of code, bookended by curly braces ({}). These code blocks follow the usual rules
    * that you would expect from a method. For example, you can return or throw exceptions
    * to exit them. It’s also possible to use braces with a single-line lambda, for example to
    * clarify where it begins and ends.
    * */
    @Test
    public void test3() {
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };
        multiStatement.run();
    }

    /*
    * Lambda expressions can also be used to represent methods that take more than one
    * argument, as in . At this juncture, it’s worth reflecting on how to read this lambda
    * expression. This line of code doesn’t add up two numbers; it creates a function that adds
    * together two numbers. The variable called add that’s a BinaryOperator<Long> isn’t the
    * result of adding up two numbers; it is code that adds together two numbers.
    * */
    @Test
    public void test4() {
        BinaryOperator<Long> add = (x, y) -> x + y;
    }

    /*
    * So far, all the types for lambda expression parameters have been inferred for us by the
    * compiler. This is great, but it’s sometimes good to have the option of explicitly writing
    * the type, and when you do that you need to surround the arguments to the lambda
    * expression with parentheses. The parentheses are also necessary if you’ve got multiple
    * arguments. This approach is demonstrated in .
    * */
    @Test
    public void test5() {
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }
}
