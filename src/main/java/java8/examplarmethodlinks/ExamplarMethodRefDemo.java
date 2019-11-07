package main.java.java8.examplarmethodlinks;



interface MyPredicate{
    boolean test(int n);
}

class MethodLinks {
    boolean isBiggerThan2(int n){
        return n >= 2;
    }
    boolean isBiggerThan20(int n){
        return n >= 20;
    }
}


public class ExamplarMethodRefDemo {

    public void main(){

        MethodLinks num1 = new MethodLinks();
        MethodLinks num2 = new MethodLinks();


        MyPredicate ip2 = num1::isBiggerThan2;
        MyPredicate ip20 = num1::isBiggerThan20;

        System.out.println(ip2.test(2));
        System.out.println(ip2.test(20));

    }
}
