import java.util.Scanner;

enum Designation{
    CLERK,
    PROGRAMMER,
    MANAGER
}
abstract class Employee{
    private String name;
    private int age;
    protected Designation designation;
    protected float salary;
    public static int employeeCount;

    public Employee(){
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

    public static void display(Employee emp){
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


class Clerk extends Employee{
    public Clerk(){
        designation = Designation.valueOf("CLERK");
    }

    public void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 2000;
    }
}

class Programmer extends Employee{
    public Programmer(){
        designation = Designation.valueOf("PROGRAMMER");
    }

    public void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 5000;
    }
}

class Manager extends Employee{
    public Manager(){
        designation = Designation.valueOf("MANAGER");
    }

    public void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 15000;
    }
}