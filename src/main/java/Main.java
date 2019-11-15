package main.java;

import main.java.java8.defaultmethods.DefaultmthodImpl;
import main.java.sorting.Sorting;
import main.java.generics.Generics;
import main.java.exceptions.MyException;
import main.java.java8.functionalinterface.FunctionalInterfaceImpl;
import main.java.java8.examplarmethodlinks.ExamplarMethodRefDemo;
import main.java.java8.predicatsandohers.PredicatsAnsOthers;
import main.java.java8.streams.Streams;
import main.java.sorting.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
/*
        Streams streams  = new Streams();
        streams.testListOfPredicates();*/

        System.out.println(Sorting.sortUsingTreeSet());


        System.out.println(Arrays.toString(Algorithms.bubbleSort(new int[]{3, 4, 5, 6, 2, 1, 5})));


    }
}





