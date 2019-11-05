package main.java.java8.defaultmethods;

interface Runner {
    default void run(){
        System.out.println("Я бегу");
    }
}

interface Eater extends Runner {
    default void eat(){
        System.out.println("Я ем");
    }
}

public class DefaultmthodImpl implements Eater {

}
