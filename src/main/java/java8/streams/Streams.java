package main.java.java8.streams;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Streams {
    public static void main() {
        List<Integer> values = new ArrayList<>(Arrays.asList(1,2,3,4));
        Predicate<Integer> a = x->x>=3;
        List<Integer> newvals = values.stream().filter(a).collect(Collectors.toList());
        System.out.println(newvals);
    }

    //creating streams
    public void create(){

        //create stream from COLLECTION
        List<Integer> list = Arrays.asList(1,2,3,4);
        Stream<Integer> stream = list.stream();

        Set<String> somestrings = new HashSet<>(Arrays.asList("one", "two", "three"));
        Stream<String> stream1 = somestrings.stream();

        //create stream from ARRAY
        Stream<Double> doubleStream = Arrays.stream(new Double[]{1.01, 1d, 0.99});

        //create stream from STRING
        IntStream intStream = "aibohphobia".chars();

        //from VALUES
        LongStream longStream = LongStream.of(111_111_111L, 333_333_333L);

        //from another STREAMS
        Stream<BigInteger> concatedStream = Stream.concat(Stream.empty(), Stream.empty());

        //use Stream.generate()
        Stream<String> stringStream = Stream.generate(String::new);
        DoubleStream doubleStream1 = DoubleStream.generate(Math::random);

        //use Stream.iterate()
        IntStream oddNumbersStream = IntStream.iterate(1, x-> x+2);

        //Use Stream.range() or Stream.rangeClosed(). Method rangeClosed() includes an upper bound.
        LongStream rangedStream = LongStream.rangeClosed(100_000, 1_000_000);



    }
}
