package com.example.demo.java8lambdas.streams;

import lombok.Data;
import org.junit.Test;

import java.util.*;

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
}
