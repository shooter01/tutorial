package main.java;

import main.java.sorting.Sorting;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Sorting sorting = new Sorting();
        sorting.sortListUsingComparatorJava8();

        /*Map<String, BigDecimal> map = new TreeMap<>();

        map.put("a", BigDecimal.ZERO);
        map.put("b", BigDecimal.ONE);
        map.put("c", BigDecimal.TEN);

        List<Map.Entry<String, BigDecimal>> mapList = map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        System.out.println(map);*/


    }
}





