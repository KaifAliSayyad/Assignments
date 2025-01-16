package assignment.classes;
import assignment.exceptions.InvalidInstantiationException;


public final class B extends A{
	private static B b = null;
	private B(){
    }

	public static B getObject(){
		try{
			if(b == null) b = new B();
			else throw new InvalidInstantiationException();
		}catch(InvalidInstantiationException e){
			System.out.println("from B");
		}catch(Exception e){
			System.out.println("from B");
		}
		return b;
	}
}

