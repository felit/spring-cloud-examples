package com.livedrof;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class streamTest {
    @Test
    public void test() {
        List<Integer> arr = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arr.add(i);
        }

        arr.stream().parallel().forEach(i -> {
            System.out.println(i);
            System.out.println(Thread.currentThread().getName());
        });
    }

    /**
     * java.lang.IllegalStateException: Duplicate key 8
     */
    @Test
    public void tt() {
        List<Integer> aa = Arrays.asList(1, 2, 3, 4, 4, 5);
        Map<Integer, Integer> map = aa.stream().collect(Collectors.toMap(Function.identity(), a -> a * 2));
        System.out.println(map);
    }

    @Test
    public void testBigDecimal() {
        BigDecimal a = new BigDecimal("8.9");
        BigDecimal b = a;
        System.out.println(a.multiply(new BigDecimal("3.4")));
        System.out.println(a);
        System.out.println(b);
    }
}
