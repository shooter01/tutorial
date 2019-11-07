package main.java.java8.staticmethodlinks;


interface IntPredicate{
    boolean test(int n);
}

class StaticMethodLinks {
    static boolean isBiggerThan2(int n){
        return n >= 2;
    }
    static boolean isBiggerThan20(int n){
        return n >= 20;
    }
}


public class MethodRefDemo {
    static boolean numTest(IntPredicate p, int v){
        return p.test(v);
    }

    public void main(){
        boolean result;
        result = numTest(StaticMethodLinks::isBiggerThan2, 1);
        System.out.println("1 bigger than 2 : " + result);

        result = numTest(StaticMethodLinks::isBiggerThan2, 26);
        System.out.println("26 bigger than 20 : " + result);
    }
}
