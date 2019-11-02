package main.java;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Map<String, BigDecimal> map = new TreeMap<>();

        map.put("a", BigDecimal.ZERO);
        map.put("b", BigDecimal.ONE);
        map.put("c", BigDecimal.TEN);


        ArrayList animals = new ArrayList();
        animals.add(new Animal(1));
        animals.add(new Animal(2));

        Collections.sort(animals);

        System.out.println(animals);



       /* List<Map.Entry<String, BigDecimal>> list = map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        System.out.println(list);*/

    }
}


class Animal implements Comparable<Animal> {
    private int age;

    Animal(int age){
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }
}


