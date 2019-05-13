package com.example.demo.java8lambdas.parallel;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {
    final String SENTENCE =
            " Nel mezzo del cammin di nostra vita " +
                    "mi ritrovai in una selva oscura" +
                    " ché la dritta via era smarrita ";

    /*
     * 7.1. Parallel streams
     *
     * Let’s suppose you need to write a method accepting a number n as argument and returning the
     * sum of all the numbers from 1 to the given argument. A straightforward (perhaps naïve)
     * approach is to generate an infinite stream of numbers, limiting it to the passed number, and
     * then reduce the resulting stream with a BinaryOperator that just sums two numbers, as follows:
     * */
    @Test
    public void test1() {
        long start = System.nanoTime();
        long nums = 10000;

        Long sum = Stream.iterate(1L, i -> i + 1)
                .limit(nums)
                .reduce(0L, Long::sum);

        long duration = System.nanoTime() - start;
        System.out.println("test1 duration time:" + duration + "  sum:" + sum);
    }

    /*
     * 7.1.1. Turning a sequential stream into a parallel one
     * */
    @Test
    public void test2() {
        long start = System.nanoTime();
        long nums = 10000;

        Long sum = Stream.iterate(1L, i -> i + 1)
                .limit(nums)
                .parallel()
                .reduce(0L, Long::sum);

        long duration = System.nanoTime() - start;
        System.out.println("test2 duration time:" + duration + "  sum:" + sum);
    }

    @Test
    public void test3() {
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
    }

    @Test
    public void test4() {
        System.out.println("Sequential sum done in: " +
                measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");
    }

    @Test
    public void test5() {
        System.out.println("Iterative sum done in: " +
                measureSumPerf(ParallelStream::iterativeSum, 10_000_000) + " msecs");
    }

    @Test
    public void test6() {
        System.out.println("Iterative sum done in: " +
                measureSumPerf(ParallelStream::parallelRangedSum, 10_000_000) + " msecs");
    }

    @Test
    public void test7() {
        System.out.println("Iterative sum done in: " +
                measureSumPerf(ParallelStream::rangedSum, 10_000_000) + " msecs");
    }

    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelRangedSum(long n) {
        /*return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(Long::sum).getAsLong();*/
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }

    @Test
    public void test8() {
        System.out.println("sideEffectSum sum done in: " +
                measureSumPerf(ParallelStream::sideEffectSum, 10_000_000) + " msecs");
    }

    @Test
    public void test9() {
        System.out.println("sideEffectSum sum done in: " +
                measureSumPerf(ParallelStream::sideEffectParallelSum, 10_000_000) + " msecs");
    }

    /*
     * 7.2. The fork/join framework
     * */
    @Test
    public void test10() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

    @Test
    public void test11() {
        System.out.println("ForkJoin sum done in: " + measureSumPerf(
                ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs");
    }

    public int countWordIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    @Test
    public void test12() {
        System.out.println("Found " + countWordIteratively(SENTENCE) + " words");
    }

    @Test
    public void test13() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        System.out.println("Found " + countWords(stream) + " words");
//        stream.forEach(System.out::println);
    }

    class WordCounter {
        private final int counter;
        private final boolean lastSpace;

        WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {
            if (Character.isWhitespace(c)) {
                return lastSpace ?
                        this :
                        new WordCounter(counter, true);
            } else {
                return lastSpace ?
                        new WordCounter(counter + 1, false) :
                        this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }

    }

    private int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    /*
     * Making the WordCounter work in parallel
     * */
    @Test
    public void test14() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        System.out.println("Found " + countWords(stream.parallel()) + " words");
//        stream.forEach(System.out::println);
    }
}