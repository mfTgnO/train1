package com.example.demo.thread;

import org.junit.Test;

import java.util.*;


/**
 * @package: com.example.demo.thread
 * @author:
 * @email:
 * @createDate: 2019-06-15 14:31
 * @description:
 */
public class SynchronizedJavaCollectionsDemo {
    /**
     * The synchronizedCollection() Method
     * <p>
     * The first synchronization wrapper that we’ll cover in this round-up
     * is the synchronizedCollection() method. As the name suggests, it returns
     * a thread-safe collection backed up by the specified Collection.
     * <p>
     * Now, to understand more clearly how to use this method, let’s create a basic unit test:
     */
    @Test
    public void test1() {
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Runnable listOperations = () -> {
            syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        };

        Thread t1 = new Thread(listOperations);
        Thread t2 = new Thread(listOperations);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncCollection.size());
    }

    @Test
    public void test2() {
//        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        List<Integer> syncCollection = new ArrayList<>();
        Runnable listOperations = () -> {
            syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        };

        Thread t1 = new Thread(listOperations);
        Thread t2 = new Thread(listOperations);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncCollection.size());
    }

    /**
     * The synchronizedList() Method
     * <p>
     * Likewise, similar to the synchronizedCollection() method, we can use the synchronizedList()
     * wrapper to create a synchronized List.
     * As we might expect, the method returns a thread-safe view of the specified List:
     */
    @Test
    public void test3() {
        List<String> syncCollection = Collections.synchronizedList(Arrays.asList("a", "b", "c", "d"));
        List<String> uppercasedCollection = new ArrayList<>();

        Runnable listOperations = () -> {
            synchronized (syncCollection) {
                syncCollection.forEach((e) -> {
                    uppercasedCollection.add(e.toUpperCase());
                });
            }
        };

        Thread t1 = new Thread(listOperations);
        Thread t2 = new Thread(listOperations);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(uppercasedCollection);
    }

    /**
     * The synchronizedMap() Method
     * <p>
     * The Collections class implements another neat synchronization wrapper,
     * called synchronizedMap(). We could use it for easily creating a synchronized Map.
     */
    @Test
    public void test4() {
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());
    }

    /**
     * The synchronizedSet() Method
     * <p>
     * Next, moving on in this review, we have the synchronizedSet() method. As its name implies,
     * it allows us to create synchronized Sets with minimal fuss.
     * The wrapper returns a thread-safe collection backed by the specified Set:
     */
    @Test
    public void test5() {
        Set<Object> syncSet = Collections.synchronizedSet(new HashSet<>());
    }

    /**
     * The synchronizedSortedSet() Method
     * <p>
     * Finally, the last synchronization wrapper that we’ll showcase here is synchronizedSortedSet().
     * Similar to other wrapper implementations that we’ve reviewed so far, the method returns
     * a thread-safe version of the given SortedSet:
     */
    @Test
    public void test6() {
        SortedSet<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());
    }
}
