package main.java.java8.streams;


import main.java.java8.helpers.*;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.*;

import static java.util.stream.Collectors.reducing;

public class Streams {
    public static void main() {
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Predicate<Integer> a = x -> x >= 3;
        List<Integer> newvals = values.stream().filter(a).collect(Collectors.toList());
        System.out.println(newvals);
    }

    //creating streams
    public void create() {

        //create stream from COLLECTION
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
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
        IntStream oddNumbersStream = IntStream.iterate(1, x -> x + 2);

        //Use Stream.range() or Stream.rangeClosed(). Method rangeClosed() includes an upper bound.
        LongStream rangedStream = LongStream.rangeClosed(100_000, 1_000_000);
    }

    public void mapMethod() {
        final List<Book> javaBooks = Stream.of(
                new Book("asd", 2013, Arrays.asList("Arunda")),
                new Book("asdas", 2013, Arrays.asList("Steve", "William"))
        ).collect(Collectors.toList());

        final List<String> authors = javaBooks
                .stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());


        System.out.println(authors);
    }

    public void reduceMethod() {
        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().reduce(0, (acc, elem) -> acc + elem);
        System.out.println(sum);
    }

    public void foreachMethod() {

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 1989, Arrays.asList("1", "2"))
        );

        list.stream().forEach(a -> a.setAuthors(Arrays.asList("33")));
        list.stream().forEach(x -> System.out.println(x.getAuthors()));
    }

    public void collectorsMethod() {

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 1989, Arrays.asList("1", "2"))
        );

        List<String> authors = list.stream().map(Book::getName).collect(Collectors.toList());
        System.out.println(authors);
    }

    public void colllectorsPartitionBy() {

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 1989, Arrays.asList("1", "2"))
        );

        Map<Boolean, List<Book>> partByyear = list.stream()
                .collect(Collectors.partitioningBy(a -> a.getYear() == 1987));
        partByyear.get(false).stream().forEach(a -> System.out.println(a.getYear()));
    }

    public void colllectorsGroupingBy() {

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2")),
                new Book("lol2", 1989, Arrays.asList("1", "2")),
                new Book("lol3", 2000, Arrays.asList("1", "2"))
        );

        Map<Integer, List<Book>> groupByYear = list.stream()
                .collect(Collectors.groupingBy(Book::getYear));
        System.out.println(groupByYear);
    }

    public void downstreamCollector() {

        List<Book> list = Arrays.asList(
                new Book("lol", 1987, Arrays.asList("1", "2"), Book.State.ACTIVE),
                new Book("lol2", 1989, Arrays.asList("1", "2"), Book.State.BLOCKED),
                new Book("lol3", 2000, Arrays.asList("1", "2"), Book.State.BLOCKED)
        );

        Map<Book.State, Long> sumByStates = list.stream()
                .collect(Collectors.groupingBy(Book::getCurrentState, Collectors.summingLong(Book::getYear)));


        System.out.println(sumByStates);
    }



    public void parallelStreams() {

        List<String> list = Arrays.asList("Java", "scala", "kotlin", "C#");

        List<String> jvmLanguages = list.parallelStream()
                .filter(lang -> !lang.equals("C#"))
                .collect(Collectors.toList());


        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

       /* intList.parallelStream()b .map(Function.identity())
                .forEach(n->System.out.println(n + " "));*/

//        System.out.println(str);
    }

    public void testDistinct() {

        List<String> str = Arrays.asList("java scala java clojure clojure".split(" "));

        Function<List<String>, List<String>> clos = (mystr) -> {
            return mystr.stream().distinct().collect(Collectors.toList());
        };


        System.out.println(clos.apply(str));

    }

    public void varsFromClosures() {

        int a = 2;
        int b = 3;
        int c = 4;

        Function<Integer, Double> y = (x) -> (double) a * Math.pow(x, 2) + b * x + c * x;

        System.out.println(y.apply(2));

    }

    public void testFilterAccounts() {

        List<Account> accounts = Arrays.asList(
                new Account("Aidar", 126786783L, true),
                new Account("Bulat", 126786783L, false),
                new Account("33", 0L, false)
        );

        List<Account> nonEmptyAccounts = filter(accounts, x -> x.getBalance() > 0);// write your code here

        System.out.println(nonEmptyAccounts);

    }

    public void testTernaryIntPredicate() {
        TernaryIntPredicate ternaryIntPredicate = (arg1, arg2, arg3) -> (arg1 != arg2 && arg1 != arg3 && arg2 != arg3) ? true : false;
        System.out.println(ternaryIntPredicate.test(20, 30, 20));
    }


    public void testCombinedproducer() {
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> {
            int v = val * 2;
            System.out.println("devnull");
        };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(300);
    }

    public void testListOfPredicates() {

        IntPredicate a1 = (arg1) -> true;
        IntPredicate a2 = (arg2) -> false;
        IntPredicate a3 = (arg3) -> false;

        List<IntPredicate> list = Arrays.asList(a1, a2, a3);

        IntPredicate mypred = Streams.disjunctAll(list);
        System.out.println(mypred.test(1));
    }


    public static boolean isPrime(final long number) {
        System.out.println(number);
        if(number == 2)
            return true;
        else
            return !LongStream.range(2, number).anyMatch((x)->{
                System.out.println(x);
                    return number % x == 0;
            });
        // write your code here
    }

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream).filter(x->x%3 == 0 && x%5==0);// write your stream here
    }


    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(" ")).filter(x->badWords.contains(x));// write your stream here
    }

    public static long factorial(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (acc, element)->acc*element);// write your code here
    }

    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        return predicates.stream().reduce((value) -> false, IntPredicate::or);
    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end).filter(x->x%2!=0).sum();
        // write your code here
    }

    public static void numbers() {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        //преобразует в вид [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
        List<Integer> generated = numbers.stream()
                .flatMap(n -> Stream.generate(() -> n).limit(n))
                .collect(Collectors.toList());

        //преобразует в вид [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
        generated = numbers.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, n))
                .boxed()
                .collect(Collectors.toList());

        //преобразует в вид [1, 2, 3, 3, 4, 5, 4, 5, 6, 7, 5, 6, 7, 8, 9]
        generated = numbers.stream()
                .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
                .boxed()
                .collect(Collectors.toList());

        //преобразует в вид [1, 2, 3, 4, 5]
        generated = numbers.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());

        System.out.println(generated);
    }

    //
    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static Map<Boolean, List<String>> isPolindrome(String[] words){
        Map<Boolean, List<String>> palindromeOrNoMap =
                Arrays.stream(words)
                        .collect(Collectors.partitioningBy(x -> {
                            return x.equals(new StringBuilder(x).reverse().toString());
                        }));
        return palindromeOrNoMap;
    }

    //ищем пользователей у которых баланс больше нуля и у которых есть отмененные транзакции, считаем сумму этих транзакций
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<main.java.java8.helpers.Account> accounts) {

/*        List<main.java.java8.helpers.Account> globalList = new ArrayList<>();

        Date created =  new Date();

        main.java.java8.helpers.Account account1 = new main.java.java8.helpers.Account("1001", 0L, false);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a", State.CANCELED,1000L, created));
        account1.setTransactions(transactions);
        globalList.add(account1);

        main.java.java8.helpers.Account account2 = new main.java.java8.helpers.Account("1002", 8000L, false);
        List<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(
                new Transaction("337868a7-f469-43c0-9042-3422ce37ee26a", State.FINISHED,8000L, created)
        );
        transactions2.add(
                new Transaction("f8047f86-89e7-4226-8b75-74c55a4d7e31", State.CANCELED,10000L, created)
        );
        account2.setTransactions(transactions2);

        globalList.add(account2);*/
        return accounts.stream().filter(x->x.getBalance()>0L).flatMap(account -> account.getTransactions().stream()).filter(x->x.getState()
                .equals(State.CANCELED)).map(Transaction::getSum).reduce(0L, Long::sum);
    }

    //выборка людей из департамента который начинается с 111 и у кого зарплата выше порога
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream().filter(x->x.getCode().startsWith("111-")).flatMap(x->x.getEmployees().stream()).filter(employee -> employee.getSalary() >= threshold).count();
    }

    public static Long produceOfIntegers(List<Integer> list){
        System.out.println(list);
        return list.stream().collect(reducing(1L,
                Integer::longValue,
                (d, n)->d*n*n
        ));
    }
}

@FunctionalInterface
interface TernaryIntPredicate {
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




/**
 * Immutable class for representing requests.
 * If you need to change the request data then create new request.
 */
class Request {
    private final String data;

    public Request(String requestData) {
        this.data = requestData;
    }

    public String getData() {
        return data;
    }
}