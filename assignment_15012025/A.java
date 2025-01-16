
package assignment.classes;
import javax.management.relation.InvalidRelationServiceException;

import assignment.exceptions.InvalidInstantiationException;


// public class A{
// 	private static A a = null;

//     public A(B b) throws InvalidInstantiationException{
// 		if(b != null && a != null) throw new InvalidInstantiationException();
//     }

// 	public static A getObject(){
// 		try{
// 			if(a == null) a = new A((B)null);
// 			else throw new InvalidInstantiationException();
// 		}catch(InvalidInstantiationException e){
// 			System.out.println(e);
// 		}
// 		return a;
// 	}
// }

public class A{
	private static A a1 = null;
	private boolean a = false;
	private boolean b = false; 

	public A(){
		if(!b && this instanceof B){
			b = true;
		}else if(!a && this instanceof A){
			a = true;
		}else{
			throw new InvalidInstantiationException();
		}
		
	}

	public static A getObject() throws InvalidInstantiationException{
		if(a1 == null) a1 = new A();
		return a1;
	}

}