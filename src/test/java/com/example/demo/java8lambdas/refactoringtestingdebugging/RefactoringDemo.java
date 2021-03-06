package com.example.demo.java8lambdas.refactoringtestingdebugging;

import com.example.demo.java8lambdas.domain.Dish;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility.HeaderTextProcessing;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.chainofresponsibility.SpellCheckerProcessing;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.factory.Loan;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.factory.Product;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.factory.ProductFactory;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer.Feed;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer.Guardian;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer.LeMonde;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.observer.NYTimes;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.strategy.IsAllLowerCase;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.strategy.IsNumeric;
import com.example.demo.java8lambdas.refactoringtestingdebugging.strategy.strategy.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static com.example.demo.java8lambdas.streams.StreamDish.menu;
import static java.util.stream.Collectors.groupingBy;

/**
 * @Package: com.example.demo.java8lambdas.refactoringtestingdebugging
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-14 10:57
 * @Description:
 */
public class RefactoringDemo {
    /*
     * 8.1.2. From anonymous classes to lambda expressions
     * */
    @Test
    public void test1() {
        // Before,using an anonymous class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        // After,using a lambda expression
        Runnable r2 = () -> System.out.println("Hello");

        r1.run();
        r2.run();
    }

    /*
     * But converting anonymous classes to lambda expressions can be a difficult process in certain
     * situations.[1] First, the meanings of this and super are different for anonymous classes and
     * lambda expressions. Inside an anonymous class, this refers to the anonymous class itself, but
     * inside a lambda it refers to the enclosing class. Second, anonymous classes are allowed to
     * shadow variables from the enclosing class. Lambda expressions can’t (they’ll cause a compile
     * error), as shown in the following code:
     * */
    @Test
    public void test2() {
        int a = 10;
        Runnable r1 = () -> {
            // compile error
//            int a = 2;
            System.out.println(a);
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                // everything is fine
                int a = 2;
                System.out.println(a);
            }
        };

        r1.run();
        r2.run();
    }


    /*
     * Finally, converting an anonymous class to a lambda expression can make the resulting code
     * ambiguous in the context of overloading. Indeed, the type of anonymous class is explicit at
     * instantiation, but the type of the lambda depends on its context. Here’s an example of how this
     * can be problematic. Let’s say you’ve declared a functional interface with the same signature as
     * Runnable, here called Task (this might occur when you need interface names that are more
     * meaningful in your model model):
     * */
    interface Task {
        public void execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }

    /*
     * You can now pass an anonymous class implementing Task without a problem:
     * */
    @Test
    public void test3() {
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });
    }

    /*
     * But converting this anonymous class to a lambda expression results in an ambiguous method
     * call, because both Runnable and Task are valid target types:
     * */
    @Test
    public void test4() {
        // Problem;both doSomething (Runnable) and doSomething (Task) match.
//        doSomething(()-> System.out.println("Danger danger!!"));
//
        // You can solve the ambiguity by providing an explicit cast (Task):
        doSomething((Task) () -> System.out.println("Danger danger!!"));
    }

    /*
     * 8.1.3. From lambda expressions to method references
     * */
    @Test
    public void test5() {
        Map<Dish.CaloricLevel, List<Dish>> dishsByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return Dish.CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return Dish.CaloricLevel.NORMAL;
                    }
                    return Dish.CaloricLevel.FAT;
                }));
        System.out.println(dishsByCaloricLevel);
    }

    /*
     * You can extract the lambda expression into a separate method and pass it as argument to
     * groupingBy. The code becomes more concise and its intent is now more explicit:
     * */
    @Test
    public void test6() {
        Map<Dish.CaloricLevel, List<Dish>> dishsByCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getCaloricLevel));
        System.out.println(dishsByCaloricLevel);
    }

    /*
     * 8.1.4. From imperative data processing to Streams
     * */
    @Test
    public void test7() {
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }
        System.out.println(dishNames);
    }

    @Test
    public void test8() {
        List<String> dishNames = menu.parallelStream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);
    }


    /*
     * Figure 8.1. The strategy design pattern
     * */
    @Test
    public void test9() {
        Validator numbericValidator = new Validator(new IsNumeric());
        boolean b1 = numbericValidator.validate("aaaa");

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");

        System.out.println(b1);
        System.out.println(b2);
    }

    /*
     * Using lambda expressions
     *
     * By now you should recognize that ValidationStrategy is a functional interface (in addition, it has
     * the same function descriptor as Predicate<String>). This means that instead of declaring new
     * classes to implement different strategies, you can pass lambda expressions directly, which are
     * more concise:
     * */
    @Test
    public void test10() {
        Validator numbericValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean b1 = numbericValidator.validate("aaaa");

        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");

        System.out.println(b1);
        System.out.println(b2);
    }

    /*
     * 8.2.2. Template method
     * */
    /*public void processCustomer(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }*/

    /*
     * 8.2.3. Observer
     *
     * It’s a pretty straightforward implementation: the feed keeps an internal list of observers that it
     * can then notify when a tweet arrives. You can now create a demo application to wire up the
     * subject and observers:
     * */
    @Test
    public void test11() {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }

    /*
     * Using lambda expressions
     * */
    @Test
    public void test12() {
        Feed feed = new Feed();
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }

    /*
     * 8.2.4. Chain of responsibility
     * */
    @Test
    public void test13() {
        HeaderTextProcessing p1 = new HeaderTextProcessing();
        SpellCheckerProcessing p2 = new SpellCheckerProcessing();

        // Chaining two processing objects
        p1.setSuccessor(p2);

        String result = p1.handle("From Raoul, Mario and Alan: Aren't lambdas really sexy?!!");
        // Prints "Aren't lambdas really sexy?!!"
        System.out.println(result);
    }

    /*
     * Using lambda expressions
     *
     * Wait a minute! This pattern looks like chaining (that is, composing) functions! We discussed
     * how to compose lambda expressions in chapter 3. You can represent the processing objects as
     * an instance of Function<String, String> or more precisely a UnaryOperator<String>. To chain
     * them you just need to compose these functions by using the andThen method!
     * */
    @Test
    public void test14() {
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result);
    }

    /*
     * 8.2.5. Factory
     * */
    @Test
    public void test15() {
        ProductFactory productFactory = new ProductFactory();
        Product p1 = productFactory.createProduct("loan");

        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();

        Product p3 = productFactory.createProductLambda("loan");
    }

    /*
     * 8.3.
     * */
    @Test
    public void test16() {

    }
}