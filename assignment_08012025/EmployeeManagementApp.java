import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		try{
				
			while(true) {
                System.out.println("-----------------------------------");
				System.out.println("1. Create");
				System.out.println("2. Display");
				System.out.println("3. Raise Salary");
				System.out.println("4. Exit");
                System.out.println("-----------------------------------");

                System.out.print("Enter choice :- ");
				int action = sc.nextInt();
				sc.nextLine();
				int id;
				int idCounter;
		
				switch (action){
					case 1:
						Employee emp;
                        int numberOfEmployeesCreated = 0;
                        while(true){
                            System.out.println("-----------------------------------");
                            System.out.println("1. Clerk");
                            System.out.println("2. Programmer");
                            System.out.println("3. Manager");
                            System.out.println("4. Exit");
                            System.out.println("-----------------------------------");

                            System.out.print("Enter choice :- ");
                            int choice = sc.nextInt();
                            sc.nextLine();
                            Designation designation;
                            float salary;
                            if(choice == 1){
                                designation = Designation.valueOf("CLERK");
                                salary = 20000;
                            }
                            else if(choice == 2){
                                designation = Designation.valueOf("PROGRAMMER");
                                salary = 30000;
                            }
                            else if(choice == 3){
                                designation = Designation.valueOf("MANAGER");
                                salary = 100_000;
                            }
                            else{
                                System.out.println("Number of Employees created :- "+numberOfEmployeesCreated);
                                break;
                            }
                            
                            System.out.print("Enter name :- ");
                            String name = sc.nextLine();
                            if(name.length() == 0){
                                System.out.println("Invalid name");
                                continue;
                            }
                            System.out.print("Enter age :- ");
                            int age = sc.nextInt();
                            if(age < 18){
                                System.out.println("Age should be greater than 18");
                                continue;
                            }
                            emp = new Employee(name, salary, age, designation);
                            numberOfEmployeesCreated += 1;
                        }
                        break;
					case 2:
                        Employee.displayAll();
                        break;
					case 3:
                        Employee.raiseSalary();
						break;
					case 4:
                        System.out.println("Total employees present : "+Employee.employees.size());
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
