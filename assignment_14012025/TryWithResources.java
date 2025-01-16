
import java.util.*;
/*

public class TryWithResources{
	public static void main(String[] args){
		A a1 = null;
		try{
			a1 = new A();
			a1.process();
			if(true) throw new NullPointerException();
		}catch(Exception e){
		
		}
		finally{
			a1.release();
		}
	}
}

class A{
	A(){
		System.out.println("Allocating resources for A class object...");
	}

	public void process(){
		System.out.println("Performing the required processing on A object..");
	}
	
	public void release(){
		System.out.println("Releasing the resources for A class object..");
	}	
}

*/


/* Problem with the above exception handling style is that even though resources are released everytime, their objects still have scope throughout the program, thus they occupy my heap memory. So in large program which runs indefinitely, it can always create a vulnerability to consume all the heap memory and our program will run out of memory. Therefore below coding style called Try With Resources should be used.*/


public class TryWithResources{
	public static void main(String[] args){
		try(A a1 = new A(); B b1 = new B();){
			a1.process();
			if(true) throw new NullPointerException();
			b1.process();
		}

		System.out.println("Program continues....");
	}
}

class A implements AutoCloseable{
	A(){
		System.out.println("Allocating resources for A class object...");
	}

	public void process(){
		System.out.println("Performing the required processing on A object..");
	}

	//compulsory to implement because we implement AutoCloseable
	public void close(){
		System.out.println("Releasing the resources for A class object..");
	}	
}

class B implements AutoCloseable{
	B(){
		System.out.println("Allocating resources for B class object...");
	}

	public void process(){
		System.out.println("Performing the required processing on B object..");
	}

	//compulsory to implement because we implement AutoCloseable
	public void close(){
		System.out.println("Releasing the resources for B class object..");
	}	
}

/*
The resources are allocated from left to right in the round brackets and released in exactly the reverse order. For example : While creating a database connection, then a collection reference, then an object reference...etc. It will automatically allocate the resources from left to right as written in try() and de-allocate them in exactly reverse order.
*/

/*
Also the statements outside try block behave as if they are in finally block by default, no need to explicitly create a finally block.
*/
