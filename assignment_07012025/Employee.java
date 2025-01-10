import java.util.*;

enum Designation{
	CLERK,
	PROGRAMMER,
	MANAGER
}

class Employee{
	public static Map<Integer, Employee> employees = new HashMap<>();
	private int id;
	private static int idCounter = 1;
	String name;
	protected float salary;
	private int age;
	public Designation designation;

	public Employee(String name, float salary, int age, Designation designation){
		this.id = idCounter;
		idCounter += 1;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		employees.put(id, this);
	}

	public static void displayAll(){
		Set<Integer> keys = employees.keySet();
		Employee emp;
		for(Integer key : keys) {
			emp = employees.get(key);
			System.out.println("______________________________________________________");
			System.out.println("Employee name is "+emp.name);
			System.out.println("Employee salary is "+emp.salary);
			System.out.println("Employee age is "+emp.age);
			System.out.println("Employee designation is "+emp.designation);
			System.out.println("______________________________________________________");
		}
			
	}
	
	public static void raiseSalary(int id, float newSalary) {
		employees.get(id).salary = newSalary;
	}
	
	public static void display(int id) {
		Employee emp = null;
		try{
			emp = employees.get(id);
		}catch(Exception e){
			System.out.println("Id not valid");
		}
		System.out.println("______________________________________________________");
		System.out.println("Employee name is "+emp.name);
		System.out.println("Employee salary is "+emp.salary);
		System.out.println("Employee age is "+emp.age);
		System.out.println("Employee designation is "+emp.designation);
		System.out.println("______________________________________________________");
		
	}

	public static int getIdCounter(){
		return idCounter;
	}

	
}