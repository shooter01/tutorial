package main.java.java8.streams;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
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

    public void mapMethod(){
        final List<Book> javaBooks = Stream.of(
                new Book("asd", 2013, Arrays.asList("Arunda")),
                new Book("asdas", 2013, Arrays.asList("Steve", "William"))
        ).collect(Collectors.toList());

        final List<String> authors = javaBooks
                .stream()
                .flatMap(book->book.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());



        System.out.println(authors);
    }

    public void reduceMethod(){
        int sum = Arrays.asList(1,2,3,4,5,6,7).stream().reduce(0, (acc, elem)->acc + elem);
        System.out.println(sum);
    }

    public void foreachMethod(){

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 1989, Arrays.asList("1", "2"))
        );

        list.stream().forEach(a->a.setAuthors(Arrays.asList("33")));
        list.stream().forEach(x-> System.out.println(x.getAuthors()));
    }

    public void collectorsMethod(){

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 1989, Arrays.asList("1", "2"))
        );

        List<String> authors = list.stream().map(Book::getName).collect(Collectors.toList());
        System.out.println(authors);
    }

    public void colllectorsPartitionBy(){

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 1989, Arrays.asList("1", "2"))
        );

        Map<Boolean, List<Book>> partByyear = list.stream()
                .collect(Collectors.partitioningBy(a->a.getYear() == 1987));
        partByyear.get(false).stream().forEach(a-> System.out.println(a.getYear()));
    }

    public void colllectorsGroupingBy(){

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 2000, Arrays.asList("1", "2"))
        );

        Map<Integer, List<Book>> groupByYear = list.stream()
                .collect(Collectors.groupingBy(Book::getYear));
        System.out.println(groupByYear);
    }

    public void downstreamCollector(){

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2"), Book.State.ACTIVE),
                new Book("lol2", 1989, Arrays.asList("1", "2"), Book.State.BLOCKED),
                new Book("lol3", 2000, Arrays.asList("1", "2"), Book.State.BLOCKED)
        );

        Map<Book.State, Long> sumByStates = list.stream()
                .collect(Collectors.groupingBy(Book::getCurrentState, Collectors.summingLong(Book::getYear)));


        System.out.println(sumByStates);
    }
    public void parallelStreams(){

        List<String> list = Arrays.asList("Java", "scala", "kotlin", "C#");

        List<String> jvmLanguages = list.parallelStream()
                .filter(lang -> !lang.equals("C#"))
                .collect(Collectors.toList());


        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7);

       /* intList.parallelStream()b .map(Function.identity())
                .forEach(n->System.out.println(n + " "));*/

//        System.out.println(str);
    }
    public void testDistinct(){

        List<String> str = Arrays.asList("java scala java clojure clojure".split(" "));

        Function<List<String>, List<String>> clos = (mystr)->{
            return mystr.stream().distinct().collect(Collectors.toList());
        };


        System.out.println(clos.apply(str));

    }
    public void varsFromClosures(){

        int a = 2;
        int b = 3;
        int c = 4;

        Function<Integer, Double> y = (x)-> (double) a*Math.pow(x,2)+b*x+c*x;

        System.out.println(y.apply(2));

    }
    public void testFilterAccounts(){

        List<Account> accounts = Arrays.asList(
                new Account("Aidar", 126786783L, true),
                new Account("Bulat", 126786783L, false),
                new Account("33", 0L, false)
        );

        List<Account> nonEmptyAccounts = filter(accounts, x->x.getBalance()>0);// write your code here

        System.out.println(nonEmptyAccounts);

    }

    public void testTernaryIntPredicate(){

        TernaryIntPredicate ternaryIntPredicate = (arg1, arg2, arg3)->(arg1 != arg2 && arg1 != arg3 && arg2 != arg3) ? true : false;


        System.out.println(ternaryIntPredicate.test(20, 30, 20));

    }


    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate){
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

@FunctionalInterface
interface TernaryIntPredicate{
    boolean test(int arg1, int arg2, int arg3);
}


class Account {
    String number;
    Long balance;
    boolean isLocked;

    public Account(String number, Long balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", isLocked=" + isLocked +
                '}';
    }
}


class Book {
    String name;
    int year;

    enum State {
        ACTIVE,
        BLOCKED,
        REMOVED,
    };

    State currentState;

    List<String> authors;

    public State getCurrentState() {
        return currentState;
    }

    Book(String name, int year, List<String> authors) {
        this.name = name;
        this.year = year;
        this.authors = authors;
    }


    Book(String name, int year, List<String> authors, State currentState) {
        this.name = name;
        this.year = year;
        this.authors = authors;
        this.currentState = currentState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
