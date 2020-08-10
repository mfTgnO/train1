package com.example.demo.collections.set;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    @Test
    public void test1() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);

        System.out.println(hashSet);
        System.out.println(Arrays.asList(hashSet));

        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < hashSet.size(); i++) {
//            if(sb.length()==0){
////                sb+=
//                Iterator<Integer> iterator = hashSet.iterator();
//                boolean b = iterator.hasNext();
//                Integer next = iterator.next();
//            }
//        }
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            if (sb.length() == 0) {
                sb.append(iterator.next().toString());
            } else {
                sb.append(",").append(iterator.next().toString());
            }
        }
        System.out.println(sb.toString());
    }
}
