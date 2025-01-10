package emp.assignment;
import java.util.Scanner;

enum Designation{
    CLERK,
    PROGRAMMER,
    MANAGER
}

public abstract class Employee{
    private int id;
    private String name;
    private int age;
    protected Designation designation;
    float salary;
    public static int employeeCount;

    public Employee(int id){
        this.id = id;
       while(getDetails());
       employeeCount++;
    }

    public boolean getDetails(){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name\t : ");
        String newName = sc.nextLine();
        if(newName.length() == 0){
            System.out.println("Invalid name");
            return true;
        }else{
            name = newName;
        }
        System.out.print("Enter the age\t : ");
        int newAge = sc.nextInt();
        if(newAge < 18){
            System.out.println("Age should be greater than 18!");
            return true;
        }else{
            age = newAge;
        }

        System.out.print("Enter salary\t : ");
        float newSalary = sc.nextFloat();
        if(newSalary < 0){
            System.out.println("Salary cannot be negative.");
            return false;
        }else{
            salary = newSalary;
        }

        return false;
    }


    public static final void display(Employee emp){
        if(employeeCount == 0){
            System.out.println("No employee present to display");
            return;
        }
        System.out.println("____________________________________________");
        System.out.println("Name\t : "+emp.name);
        System.out.println("Age\t : "+emp.age);
        System.out.println("Salary\t : "+emp.salary);
        System.out.println("Designation\t : "+emp.designation);
        System.out.println("____________________________________________");
    }

    public abstract void raiseSalary();
    
}