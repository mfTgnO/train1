package com.example.demo.java8lambdas.streams;

import com.example.demo.java8lambdas.domain.Dish;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.example.demo.java8lambdas.streams.StreamDish.menu;
import static java.util.stream.Collectors.*;

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
        System.out.println(transactionByCurrencies);
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
                .collect(counting());

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
        } else {
            System.out.println("empty");
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
        } else {
            System.out.println("empty");
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
     *
     * 平均计算
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
        System.out.println(menuStatistics.getMax());
        System.out.println(menuStatistics.getCount());
        System.out.println(menuStatistics.getAverage());
        System.out.println(menuStatistics.getMin());
        System.out.println(menuStatistics.getSum());
    }

    /*
     * 6.2.3. Joining Strings
     * */
    @Test
    public void test9() {
        String shortMenu = menu.stream()
                .map(Dish::getName)
//                .collect(Collectors.joining());
                .collect(Collectors.joining("***"));
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
//        Integer totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        Integer totalCalories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
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

    @Test
    public void test14() {
        Integer totalCalories = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
//        Integer totalCalories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        /*Integer totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();*/
        System.out.println(totalCalories);
    }

    @Test
    public void test15() {
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());
        System.out.println(shortMenu);
    }

    @Test
    public void test16() {
        /*String shortMenu = menu.stream()
                .collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + s2));*/
        String shortMenu = menu.stream().map(Dish::getName).reduce("", (s1, s2) -> s1 + s2);
        System.out.println(shortMenu);
    }

    /*
     * 6.3. Grouping
     * */
    @Test
    public void test17() {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }

    /*
     * Figure 6.4. Classification of an item in the stream during the grouping
     * process
     *
     * Listing 6.2. Multilevel grouping
     * */
    @Test
    public void test18() {
        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return Dish.CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return Dish.CaloricLevel.NORMAL;
                    } else {
                        return Dish.CaloricLevel.FAT;
                    }
                }));
        System.out.println(dishesByCaloricLevel);
    }

    /*
     * 6.3.2. Collecting data in subgroups
     * */
    @Test
    public void test19() {
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);
    }

    /*
     * To give another example, you could rework the collector you already used to find the
     * highest-calorie dish in the menu to achieve a similar result, but now classified by the type of
     * dish:
     * */
    @Test
    public void test20() {
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(mostCaloricByType);
    }

    /*
     * Adapting the collector result to a different type
     * */
    @Test
    public void test21() {
        /*Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));*/
        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);
    }

    /*
     * Other examples of collectors used in conjunction with groupingBy
     * */
    @Test
    public void test22() {
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);
    }

    /*
     * Yet another collector, commonly used in conjunction with groupingBy, is one generated by the
     * mapping method. This method takes two arguments: a function transforming the elements in a
     * stream and a further collector accumulating the objects resulting from this transformation. Its
     * purpose is to adapt a collector accepting elements of a given type to one working on objects of a
     * different type, by applying a mapping function to each input element before accumulating them.
     * To see a practical example of using this collector, suppose you want to know which CaloricLevels
     * are available in the menu for each type of Dish. You could achieve this result combining a
     * groupingBy and a mapping collector as follows:
     * */
    @Test
    public void test23() {
        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return Dish.CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return Dish.CaloricLevel.NORMAL;
                            } else {
                                return Dish.CaloricLevel.FAT;
                            }
                        }, toSet()
                )));
        System.out.println(caloricLevelsByType);
    }


    /*
     * From this you can easily figure out your choices. If you’re in the mood for fish and you’re on a
     * diet, you could easily find a dish; likewise, if you’re very hungry and want something with lots of
     * calories, you could satisfy your robust appetite by choosing something from the meat section of
     * the menu. Note that in the previous example, there are no guarantees about what type of Set is
     * returned. But by using toCollection, you can have more control. For example, you can ask for a
     * HashSet by passing a constructor reference to it:
     * */
    @Test
    public void test24() {
        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return Dish.CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return Dish.CaloricLevel.NORMAL;
                            } else {
                                return Dish.CaloricLevel.FAT;
                            }
                        }, toCollection(HashSet::new)
                )));
        System.out.println(caloricLevelsByType);
    }

    /*
     * 6.4. Partitioning
     * */
    @Test
    public void test25() {
        Map<Boolean, List<Dish>> partitiondMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitiondMenu);

//        So you could retrieve all the vegetarian dishes by getting from this Map the value indexed with
//        the key true:
        List<Dish> vegetarianDishes = partitiondMenu.get(true);
        System.out.println(vegetarianDishes);
    }

    /*
     * Note that you could achieve the same result by just filtering the stream created from the menu
     * List with the same predicate used for partitioning and then collecting the result in an additional
     * List:
     * */
    @Test
    public void test26() {
        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(vegetarianDishes);
    }

    /**
     * 数组求和
     */
    @Test
    public void test27() {
        int[] nums = new int[]{123456789, 23456789, 3456789, 456789, 56789, 6789, 789, 89, 9};
        OptionalInt sum = Arrays.stream(nums).reduce(Integer::sum);
        System.out.println(sum.getAsInt());
    }

    /**
     * 先分割，再分组
     * 6.4.1. Advantages of partitioning
     */
    @Test
    public void test28() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);
    }

    /*
     * Here the grouping of the dishes by their type is applied individually to both of the substreams of
     * vegetarian and nonvegetarian dishes resulting from the partitioning, producing a two-level Map
     * that’s similar to the one you obtained when you performed the two-level grouping in section
     * 6.3.1. As another example, you can reuse your earlier code to find the most caloric dish among
     * both vegetarian and nonvegetarian dishes:
     * */
    @Test
    public void test29() {
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(
                        maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    /**
     * 二次分割
     */
    @Test
    public void test30() {
        Map<Boolean, Map<Boolean, List<Dish>>> collect = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(collect);
    }

    /**
     * 分割求和
     */
    @Test
    public void test31() {
        Map<Boolean, Long> collect = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(collect);
    }

    /**
     * 将数字划分为素数和非素数
     * 6.4.2. Partitioning numbers into prime and nonprime
     */
    @Test
    public void test32() {
        int candidate = 5;
        boolean prime = IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
        System.out.println(prime);
    }

    /*
     * A simple optimization is to test only for factors less than or equal to the square root of the
     * candidate:
     * */
    @Test
    public void test33() {
        int candidate = 5;
        double candidateRoot = Math.sqrt((double) candidate);
        boolean prime = IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
        System.out.println(prime);
    }


    /**
     * 计算平均数时，集合为空
     */
    @Test
    public void test34() {
        List<Integer> list = new ArrayList<>();
        Double avgCalories = list.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avgCalories);
    }
}
