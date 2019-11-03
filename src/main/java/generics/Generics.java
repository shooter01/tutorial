package main.java.generics;

public class Generics {

    public void example(){
        GenericExample<Integer> integer = new GenericExample<>();
        integer.setO(77);
        integer.getO();
        integer.setO(88);
        integer.getO();
        System.out.println("==GenereicMethodDemo (обобщенный метод) ==");
        GenericMethodDemo genereicMethodDemo = new GenericMethodDemo();

        //объявляем массив
        Integer nums[] = {1,2,3,4};
        Integer nums2[] = {1,2,3,4};
        System.out.println(GenericMethodDemo.arraysEqual(nums, nums2));
        
        
        System.out.println("==Summation (обобщенный конструктор) ==");
        Summation summation = new Summation(4);

        System.out.println("сумма чисел до 4 : " + summation.getSum());


        System.out.println("==Containtment (обобщенный интерфейс) ==");

        Integer[] myarr = {1,2,3,4};

        MyClass<Integer> ob = new MyClass<>(myarr);

        System.out.println("Содержится ли 1 в массиве? {1,2,3,4} " + ob.contains(1));



    }

}


class GenericExample <T> {
    private T o;
    void setO(T o){
        this.o = o;
    }

    void getO() {
        System.out.println(o);
    }
}


class Summation {
    private int sum;

    /**
     * обобщение сверху Number
     */
    <T extends Number> Summation (T arg){
        sum = 0;

        for (int i = 0; i <= arg.intValue(); i++) {
            sum+=i;
        }
    }

    int getSum(){
        return sum;
    }
}



class GenericMethodDemo {
    /**
     * параметры типа перед возвращаемым типом
     * Comparable определен в java.lang
     * V ограничено T, если T передается как Integer то V автоматически становится Integer
     */
    static <T extends Comparable<T>, V extends T> boolean
            arraysEqual (T[]x, V[]y){
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) return false;
        }
        return true;
    }
}

/**
 * обобщенный интерфейс
 * @param <T>
 */
interface Containtment<T>{
    boolean contains(T o);
}

class MyClass<T> implements Containtment<T>{
    T[] arrayRef;
    MyClass(T[]o){
        arrayRef = o;
    }
    public boolean contains(T o){
        for (T t : arrayRef) {
            if (t.equals(o)) return true;
        }
        return false;
    }
}