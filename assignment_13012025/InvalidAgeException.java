package emp.exceptions;


public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(){
        System.out.println("Age should be between 21 - 60");
    }

    public InvalidAgeException(String e){
        System.out.println("Age should be between 21 - 60");
    }

}
