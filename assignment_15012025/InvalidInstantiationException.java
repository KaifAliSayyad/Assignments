package assignment.exceptions;

public class InvalidInstantiationException extends RuntimeException{
	public InvalidInstantiationException(){
		System.out.println("Cannot create more than one objects for this class");
	}

	public InvalidInstantiationException(String e){
		System.out.println(e);
	}
}