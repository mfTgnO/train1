package com.example.demo.java8lambdas.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @package: com.example.demo.java8lambdas.streams
 * @author:
 * @email:
 * @createDate: 2019-05-24 17:39
 * @description:
 */
public class SubsetsMain {
    @Test
    public void test1() {
        List<List<Integer>> subs = subsets(Arrays.asList(1, 4, 9));
        subs.forEach(System.out::println);
    }

    private List<List<Integer>> subsets(List<Integer> l) {
        if (l.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = l.get(0);
        List<Integer> rest = l.subList(1, l.size());
        List<List<Integer>> subbans = subsets(rest);
        List<List<Integer>> subbans2 = insertAll(first, subbans);
        return concat(subbans, subbans2);
    }

    private List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    private List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }
}
