package emp.assignment;
import java.util.InputMismatchException;
import java.util.Scanner;
import emp.exceptions.InvalidAgeException;
import emp.exceptions.InvalidChoiceException;
import emp.exceptions.InvalidIdException;
import emp.exceptions.InvalidSalaryException;
import emp.utils.Menu;

enum Designation{
    CLERK,
    PROGRAMMER,
    MANAGER,
    CEO
}

public abstract class Employee{
    private String id;
    private String name;
    protected int age;
    protected Designation designation;
    private float salary;
    public static int employeeCount;
    static int minAge;
    static int maxAge;
    private static boolean isCeoPresent = false;

    public Employee(String id, int minAge, int maxAge){
        this.id = id;
        this.minAge = minAge;
        this.maxAge = maxAge;
       while(getDetails());
       employeeCount++;
    }


    public boolean getDetails(){
        
        name = Menu.readName();
        age = Menu.readAge(minAge, maxAge);
        salary = Menu.readSalary();

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


    protected void setBoolean(){
        isCeoPresent = true;
    }

    public static boolean getBoolean(){
        return isCeoPresent;
    }

    // public abstract void raiseSalary();

    public void raiseSalary(){
        switch (this.designation) {
            case CLERK:
                this.salary += 2000;
                break;
            case PROGRAMMER:
                this.salary += 5000;
                break;
            case MANAGER:
                this.salary += 15000;
                break;
            case CEO:
                this.salary += 150000;
                break;
        }
    }

    public abstract void setMinAge(int age);
    
    public abstract void setMaxAge(int age);

    
}