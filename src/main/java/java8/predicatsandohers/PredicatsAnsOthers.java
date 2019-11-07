package main.java.java8.predicatsandohers;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;


class Employee {
    String name;
    Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class PredicatsAnsOthers {

    public static void main() {
           /* List<Integer> list = Arrays.asList(10,20,30,40,50,60);
        UnaryOperator<Integer> unaryOpt = i->i*i;
        BinaryOperator<Integer> Bin = i->i*i;

        ArrayList<Integer> newlist = new ArrayList<>();

        list.forEach(i->newlist.add(unaryOpt.apply(i)));
*/


        Function<Employee, String> funcEmpToString = (Employee e) -> e.getName();
        Function<String,String> initialFunction= (String s)->s.substring(0,1);
        Function<Employee, Employee> funcEmpFirstName=
                (Employee e)-> {int index= e.getName().indexOf(" ");
                    String firstName=e.getName().substring(0,index);
                    e.setName(firstName);
                    return e;};

        List<Employee> employees = Arrays.asList(
                new Employee("Thomas Anders", 30),
                new Employee("Jenna Williams", 25));



        /**
         * FUNCTION
         */



        List<String> nameList = new ArrayList<>();
        employees.forEach(i->nameList.add(funcEmpToString.apply(i)));
        System.out.println(nameList);


        /**
         * FUNCTION + andThen (andThen() default method combines the current Function instance with another one and
         * returns a combined Function instance which applies the two functions in sequence with the function passed
         * as parameter to andThen() being invoked AFTER the current function.)
         */

        nameList.clear();
        employees.forEach(i->nameList.add(funcEmpToString.andThen(initialFunction).apply(i)));
        System.out.println(nameList);

        /**
         * FUNCTION + COMPOSE compose() default method combines the current Function instance with another one and
         * returns a combined Function instance which applies the two functions in sequence with the parameter function
         * to compose() being invoked BEFORE the current function.
         */

        nameList.clear();
        employees.forEach(i->nameList.add(funcEmpToString.compose(funcEmpFirstName).apply(i)));
        System.out.println(nameList);


        employees.forEach(System.out::println);


    }




}
