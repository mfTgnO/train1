package com.example.demo.java8lambdas.functional;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @package: com.example.demo.java8lambdas.functional
 * @author:
 * @email:
 * @createDate: 2019-06-01 10:51
 * @description:
 */
public class LazyLists {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<Integer>()));
        System.out.println(list.head());

        LazyList<Integer> numbers = from(2);
        Integer two = numbers.head();
        Integer three = numbers.tail().head();
        Integer four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);

        numbers = from(2);
        Integer prime_two = primes(numbers).head();
        Integer prime_three = primes(numbers).tail().head();
        Integer prime_five = primes(numbers).tail().tail().head();
        System.out.println(prime_two + " " + prime_three + " " + prime_five);
    }

    interface MyList<T> {
        T head();

        MyList<T> tail();

        default boolean isEmpty() {
            return true;
        }

        MyList<T> filter(Predicate<T> p);
    }

    static class MyLinkedList<T> implements MyList<T> {
        final T head;
        final MyList<T> tail;

        MyLinkedList(T head, MyList<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            return tail;
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return isEmpty() ? this :
                    p.test(head()) ? new MyLinkedList<>(head(), tail().filter(p)) :
                            tail().filter(p);
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    static class Empty<T> implements MyList<T> {
        @Override
        public T head() {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyList<T> tail() {
            throw new UnsupportedOperationException();
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return this;
        }
    }

    static class LazyList<T> implements MyList<T> {
        final T head;
        final Supplier<MyList<T>> tail;

        LazyList(T head, Supplier<MyList<T>> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public MyList<T> tail() {
            return tail.get();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public MyList<T> filter(Predicate<T> p) {
            return isEmpty() ? this
                    : p.test(head()) ? new LazyList<>(head(), () -> tail().filter(p)) :
                    tail().filter(p);
        }
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail()
                .filter(n -> n % numbers.head() != 0)));
    }

    static <T> void printAll(MyList<T> numbers) {
        if (numbers.isEmpty()) {
            return;
        }
        System.out.println(numbers.head());
        printAll(numbers.tail());
    }
}
