import java.util.*;

enum Designation{
	CLERK,
	PROGRAMMER,
	MANAGER
}

class Employee{
	public static List<Employee> employees = new ArrayList<>();
	String name;
	private float salary;
	private int age;
	private Designation designation;

	public Employee(String name, float salary, int age, Designation designation){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		employees.add(this);
	}

	public static void displayAll(){
		for(Employee emp : employees){
            System.out.println("______________________________________________________");
            System.out.println("Employee name is "+emp.name);
            System.out.println("Employee salary is "+emp.salary);
            System.out.println("Employee age is "+emp.age);
            System.out.println("Employee designation is "+emp.designation);
            System.out.println("______________________________________________________");
        }
			
	}
	
	public static void raiseSalary() {
		for(Employee emp : employees){
            if(emp.designation == Designation.valueOf("CLERK")){
                emp.salary += 2000;
            }
            else if(emp.designation == Designation.valueOf("PROGRAMMER")){
                emp.salary += 5000;
            }
            else emp.salary += 15000;
        }
	}

}