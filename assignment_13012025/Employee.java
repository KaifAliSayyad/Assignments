package emp.assignment;
import java.util.InputMismatchException;
import java.util.Scanner;
import emp.exceptions.InvalidAgeException;
import emp.exceptions.InvalidChoiceException;
import emp.exceptions.InvalidIdException;
import emp.exceptions.InvalidSalaryException;

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


        try{
            System.out.print("Enter the age\t : ");
            int newAge = sc.nextInt();
        
            if(newAge < 20 || newAge > 60){
                throw new InvalidAgeException();
            }else{
                age = newAge;
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter numbers only...");
            return true;
        }catch(InvalidAgeException e){
            return true;
        }

        try{
            System.out.print("Enter salary\t : ");
            float newSalary = sc.nextFloat();
            if(newSalary < 0){
                throw new InvalidSalaryException();
            }else{
                salary = newSalary;
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter numbers only...");
            return true;
        }catch(InvalidSalaryException e){
            return true;
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