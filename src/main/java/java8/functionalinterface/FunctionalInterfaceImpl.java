package main.java.java8.functionalinterface;

@FunctionalInterface
interface MyInterface {
    double work();
}


public class FunctionalInterfaceImpl {
    public void main(){
        MyInterface myInterface = () -> 98.6;
        System.out.println(myInterface.work());


        MyInterface anotherExample = () -> 100;
        System.out.println(anotherExample.work());

    }
}
