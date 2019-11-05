package main.java.exceptions;


public class MyException {

    public void throwException(){
        try {
            if (true){
                throw new VeryBigException("I am in troubles!");
            }
        } catch(VeryBigException e){
            System.out.println(e.getMessage());
        }

    }

}


class VeryBigException extends Exception {
    VeryBigException(String message){
        super(message);
    }
}


