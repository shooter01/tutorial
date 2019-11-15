package main.java.sorting;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Sorting {

    public void sortMapUsingStream(){
        Map<String, BigDecimal> map = new TreeMap<>();

        map.put("a", BigDecimal.ZERO);
        map.put("b", BigDecimal.ONE);
        map.put("c", BigDecimal.TEN);

        List<Map.Entry<String, BigDecimal>> mapList = map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        System.out.println(mapList);

    }



    //Animal implements comparable !!!!
    public void sortListUsingComparableInterface(){

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Animal(1));
        arrayList.add(new Animal(2));
        arrayList.add(new Animal(3));
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    public static Set<Animal> sortUsingTreeSet(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Animal(1));
        arrayList.add(new Animal(2));
        arrayList.add(new Animal(3));

        Set<Animal> set = new TreeSet<>(Comparator.comparing(Animal::getAge).reversed());
        set.addAll(arrayList);
        return set;
//        System.out.println(set);
    }



    public void sortListUsingComparatorJava8(){

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Animal(1));
        arrayList.add(new Animal(2));
        arrayList.add(new Animal(3));

        Collections.sort(arrayList, Comparator.comparing(Animal::getAge).reversed());
        System.out.println(arrayList);

    }

    public void sortListUsingComparator(){


        Comparator<Animal> animalComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal animal, Animal t1) {
                return t1.getAge() - animal.getAge();
            }
        };

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Animal(1));
        arrayList.add(new Animal(2));
        arrayList.add(new Animal(3));

        Collections.sort(arrayList, animalComparator);

        System.out.println(arrayList);


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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
