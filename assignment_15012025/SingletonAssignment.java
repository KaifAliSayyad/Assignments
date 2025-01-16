import assignment.classes.A;
import assignment.classes.B;
import assignment.exceptions.InvalidInstantiationException;
import java.lang.NoSuchMethodError;

public class SingletonAssignment{
	public static void main(String[] args){
		A a1 = A.getObject();
		B b1 = B.getObject();


		System.out.println(a1);
		System.out.println(b1);

		A a2 = A.getObject();
		B b2 = B.getObject();
		System.out.println(a2);
		System.out.println(b2);

		try{
			A a3 = new A();
			System.out.println(a3);
		}catch(NoSuchMethodError e){
			System.out.println("from main");
		}

		// B b3 = new B();
		// System.out.println(b3);

	}

	
}
