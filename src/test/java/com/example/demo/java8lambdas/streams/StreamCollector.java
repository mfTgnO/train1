package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Dish;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.java8lambdas.streams.StreamDish.menu;

public class StreamCollector {
    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }

    @Data
    public static class Transaction {
        private final Currency currency;
        private final double value;
    }

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0));

    /*
     * Listing 6.1. Grouping transactions by currency in imperative style
     *
     * Excited? Great, let’s start by exploring an example that benefits from collectors. Imagine a
     * scenario where you have a List of Transactions, and you want to group them based on their
     * nominal currency. In pre-lambda Java, even a simple use case like this is cumbersome to
     * implement, as shown in the following listing.
     * */
    @Test
    public void test1() {
        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        System.out.println(transactionByCurrencies);
        /*
        * {
        GBP=[StreamCollector.Transaction(currency=GBP, value=9900.0), StreamCollector.Transaction(currency=GBP, value=3200.0)],

        JPY=[StreamCollector.Transaction(currency=JPY, value=7800.0), StreamCollector.Transaction(currency=JPY, value=5700.0)],

        USD=[StreamCollector.Transaction(currency=USD, value=2300.0), StreamCollector.Transaction(currency=USD, value=4500.0), StreamCollector.Transaction(currency=USD, value=4600.0)],

        EUR=[StreamCollector.Transaction(currency=EUR, value=1500.0), StreamCollector.Transaction(currency=EUR, value=1100.0), StreamCollector.Transaction(currency=EUR, value=5600.0), StreamCollector.Transaction(currency=EUR, value=6800.0)],

        CHF=[StreamCollector.Transaction(currency=CHF, value=6700.0), StreamCollector.Transaction(currency=CHF, value=3400.0)]
        }
        * */
    }

    @Test
    public void test2() {
        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionByCurrencies
                    .computeIfAbsent(currency, k -> new ArrayList<>());
            transactionsForCurrency.add(transaction);
        }
    }

    /*
     * 6.2. Reducing and summarizing
     *
     * As a first simple example, let’s count the number of dishes in the menu, using the collector
     * returned by the counting factory method:
     * */
    @Test
    public void test3() {
        Long howManyDishes = menu.stream()
                .collect(Collectors.counting());

        // You can write this far more directly as
        /*Long howManyDishes = menu.stream().count();*/

        System.out.println(howManyDishes);
    }

    /*
     * 6.2.1. Finding maximum and minimum in a stream of values
     *
     * Suppose you want to find the highest-calorie dish in the menu. You can use two collectors,
     * Collectors.maxBy and Collectors.minBy, to calculate the maximum or minimum value in a
     * stream. These two collectors take a Comparator as argument to compare the elements in the
     * stream. Here you create a Comparator comparing dishes based on their calorie content and pass
     * it to Collectors.maxBy:
     * */
    @Test
    public void test4() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);
        /*Optional<Dish> mostCalorieDish = menu.stream()
                .collect(Collectors.maxBy(dishCaloriesComparator));*/
        Optional<Dish> mostCalorieDish = menu.stream().max(dishCaloriesComparator);

        if (mostCalorieDish.isPresent()) {
            Dish dish = mostCalorieDish.get();
            System.out.println(dish);
        }
    }

    @Test
    public void test5() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);
        /*Optional<Dish> lessCalorieDish = menu.stream()
                .collect(Collectors.minBy(dishCaloriesComparator));*/
        Optional<Dish> lessCalorieDish = menu.stream().min(dishCaloriesComparator);

        if (lessCalorieDish.isPresent()) {
            Dish dish = lessCalorieDish.get();
            System.out.println(dish);
        }
    }


    /*
     * 6.2.2. Summarization
     *
     * The Collectors class provides a specific factory method for summing: Collectors .summingInt. It
     * accepts a function that maps an object into the int that has to be summed and returns a collector
     * that, when passed to the usual collect method, performs the requested summarization. So, for
     * instance, you can find the total number of calories in your menu list with
     *
     * Collectors.summingLong
     * Collectors.summingDouble
     * */
    @Test
    public void test6() {
        Integer totalCalories = menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        /*Integer totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();*/
        System.out.println(totalCalories);
    }

    /*
     * But there’s more to summarization than mere summing; also available is a
     * Collectors .averagingInt, together with its averagingLong and averagingDouble counterparts, to
     * calculate the average of the same set of numeric values:
     *
     * Collectors.averagingLong
     * Collectors.averagingDouble
     * */
    @Test
    public void test7() {
        Double avgCalories = menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
    }

    /*
     * Quite often, though, you may want to retrieve two or more of these results, and possibly
     * you’d like to do it in a single operation. In this case, you can use the collector returned by the
     * summarizingInt factory method. For example, you can count the elements in the menu and
     * obtain the sum, average, maximum, and minimum of the calories contained in each dish with a
     * single summarizing operation:
     *
     * Collectors.summarizingLong
     * Collectors.summarizingDouble
     * */
    @Test
    public void test8() {
        IntSummaryStatistics menuStatistics = menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics.toString());
    }

    /*
     * 6.2.3. Joining Strings
     * */
    @Test
    public void test9() {
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());
        System.out.println(shortMenu);
    }

    /*
     * which isn’t very readable. Fortunately, the joining factory method has an overloaded version
     * that accepts a delimiter string between two consecutive elements, so you can obtain a
     * comma-separated list of the dishes’ names with
     * */
    @Test
    public void test10() {
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));
        System.out.println(shortMenu);
    }

    /*
     * 6.2.4. Generalized summarization with reduction
     * */
    @Test
    public void test11() {
        /*Integer totalCalories = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));*/
        Integer totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        System.out.println(totalCalories);
    }

    /*
     * Similarly, you could find the highest-calorie dish using the one-argument version of reducing as
     * follows:
     * */
    @Test
    public void test12() {
        /*Optional<Dish> mostCalorieDish = menu.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));*/
        Optional<Dish> mostCalorieDish = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        if (mostCalorieDish.isPresent()) {
            Dish dish = mostCalorieDish.get();
            System.out.println(dish);
        }
    }

    /*
     * Collect vs. reduce
     * */
    @Test
    public void test13() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                }
        );
        System.out.println(numbers);
    }
}
