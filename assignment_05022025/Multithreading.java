
class A
{
	public void print1to10()
	{
		for(int i=1; i<=10; i++)
		{	
			//Thread.sleep(500);
			System.out.println("Range : "+i);
		}
	}
}
class B
{
	public void evenTill50()
	{
		for(int i=0; i<=50; i+=2)
		{	
			//Thread.sleep(1000);
			System.out.println("Even : "+i);
		}
	}
}
class C
{
	public void fib()
	{	
		int a = 0, b = 1;

	        for (int i = 0; a <= 1000; i++) {
		    //Thread.sleep(2000);
	            System.out.println(i+"(st/nd/rd/th) Fibonacci = "+a);
		    int c = b + a;
	            a = b;
        	    b = c;
	        }
	}
}
class Multithreading
{
	public static void main(String args[]) throws Exception
	{
		/*
		Runnable r1 = ()->{
			try{
				A a = new A();
				a.print1to10();
			}catch(Exception e){
				e.printStackTrace();
			}
		};
		Runnable r2 = ()->{
			try{
				B b = new B();
				b.evenTill50();
			}catch(Exception e){
				e.printStackTrace();
			}
		};
		Runnable r3 = ()->{
			try{
				C c = new C();
				c.fib();
			}catch(Exception e){
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
		Thread t3 = new Thread(r3);
		t3.start();
		*/
		
		new Thread(new A()::print1to10).start();
		new Thread(new B()::evenTill50).start();
		new Thread(new C()::fib).start();
		
		
	}
}