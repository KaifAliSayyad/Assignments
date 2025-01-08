import java.util.*;
import java.lang.IllegalArgumentException;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		try{
				
			while(true) {
				System.out.println("What action do you want to perform ?");
				System.out.println("1. Create a new Employee");
				System.out.println("2. Raise salary of an existing Employee");
				System.out.println("3. Display all employees");
				System.out.println("4. Display particular employee");
				System.out.println("5. Exit");
				int action = sc.nextInt();
				sc.nextLine();
				int id;
				int idCounter;
		
				switch (action){
					case 1:
						Employee emp;
						try{
							System.out.print("Enter the name of the Employee : ");
							String name = sc.nextLine();
							if(name.length() == 0) throw new IllegalArgumentException("Invalid name");
							
							System.out.print("\nEnter the age of the Employee : ");
							int age = sc.nextInt();
							if(age < 0) throw new IllegalArgumentException("Age cannot be less than zero");
							
							System.out.print("\nEnter the salary of the Employee : ");
							float salary = sc.nextFloat();
							if(salary < 0) throw new IllegalArgumentException("Salary cannot be less than zero");
							
							System.out.print("\nSelect the designation of the Employee : \n 1. Clerk\n 2. Programmer\n 3. Manager\n->");
							int x = sc.nextInt();
							Designation designation;
							switch (x){
								case 1:
									designation = Designation.valueOf("CLERK");
								break;
								
								case 2:
									designation = Designation.valueOf("PROGRAMMER");
								break;
								
								case 3:
									designation = Designation.valueOf("MANAGER");
								break;
								
								default: throw new IllegalArgumentException("Invalid option.");
							}
							
							emp = new Employee(name, salary, age, designation);
						
							System.out.println("\nEmployee has been created successfully.");
						}catch(IllegalArgumentException err) {
							System.out.println(err);
						}
						
						break;
					case 2:
						idCounter = Employee.getIdCounter();
						System.out.print("Enter the id of the Employee you want to raise salary from (1 -"+(idCounter-1)+"):");
						id = sc.nextInt();
						System.out.println("\nEnter the new salary of the employee :");
						float newSalary = sc.nextFloat();
						Employee.raiseSalary(id, newSalary);
					case 3:
						Employee.displayAll();
						break;
					case 4:
					idCounter = Employee.getIdCounter();
						System.out.print("\nEnter the id of Employee you want to display (1 -"+(idCounter-1)+"):");
						id = sc.nextInt();
						Employee.display(id);
						break;
					case 5:
						System.exit(0);
						break;
					default: throw new IllegalArgumentException("Invalid option.");
				}
			}
		}catch(Exception e){
			System.out.println("An error occured! Please try again :(\n Error : "+e);
			main(new String[]{});
		}
	}
}