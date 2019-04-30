package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Trader;
import com.example.demo.java8lambdas.domain.Transaction;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Package: com.example.demo.java8lambdas.streams
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-30 14:53
 * @Description:
 */
public class StreamTransaction {
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /*
     * 1. Find all transactions in the year 2011 and sort them by value (small to high).
     * */
    @Test
    public void test1() {
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test2() {
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
     * 2. What are all the unique cities where the traders work?
     * */
    @Test
    public void test3() {
        List<String> collect = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test3_Optimization1() {
        List<String> collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
     * You haven’t seen this yet, but you could also drop distinct() and use toSet() instead, which
     * would convert the stream into a set. You’ll learn more about it in chapter 6.
     * */
    @Test
    public void test3_Optimization2() {
        Set<String> collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    /*
     * 3. Find all traders from Cambridge and sort them by name.
     * */
    @Test
    public void test4() {
        List<Trader> collect = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /*
     * 4. Return a string of all traders’ names sorted alphabetically.
     * */
    @Test
    public void test5() {
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + "--->" + n2);
        System.out.println(names);
    }

    @Test
    public void test5_Optimization1() {
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining("--->"));
        System.out.println(names);
    }

    // 5. Are any traders based in Milan?
    @Test
    public void test6() {
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity()
                        .equals("Milan"));
        System.out.println(milanBased);
    }

    /*
     * 6. Print all transactions’ values from the traders living in Cambridge.
     * */
    @Test
    public void test7() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /*
     * 7. What’s the highest value of all the transactions?
     * */
    @Test
    public void test8() {
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        if (maxValue.isPresent()) {
            Integer integer = maxValue.get();
            System.out.println(integer);
        }
    }

    /*
     * 8. Find the transaction with the smallest value.
     * */
    @Test
    public void test9() {
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        if (maxValue.isPresent()) {
            Integer integer = maxValue.get();
            System.out.println(integer);
        }
    }

    /*
     * You can do better. A stream supports the methods min and max that take a Comparator as
     * argument to specify which key to compare with when calculating the minimum or maximum:
     * */
    @Test
    public void test10() {
        Optional<Transaction> minValue = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        if (minValue.isPresent()) {
            Transaction transaction = minValue.get();
            System.out.println(transaction);
        }
    }
}
