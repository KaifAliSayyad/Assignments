import java.util.InputMismatchException;
import java.util.*;
import emp.assignment.Employee;
import emp.assignment.Clerk;
import emp.assignment.Programmer;
import emp.assignment.Manager;
import emp.exceptions.InvalidAgeException;
import emp.exceptions.InvalidChoiceException;
import emp.exceptions.InvalidIdException;


public class EmployeeManagementApp {
    static Employee[] employees = new Employee[100];
    static int employeeCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("________________________________________");
            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    while(createMenu());
                    System.out.println("Total employees added : "+(employeeCount));
                    break;
                
                case 2:
                    display();
                    break;
                case 3:
                    raiseSalary();
                    break;
                case 4:
                    while(delete());
                    break;
                case 5: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static boolean delete(){
        Scanner sc = new Scanner(System.in);
        int startingIndexForDeletion = 0;
        while(employees[startingIndexForDeletion] == null) startingIndexForDeletion++;
        try{
            System.out.println("Entering any number apart from this will exit this menu.");
            System.out.print("Enter the id of the employee you want to delete ("+(startingIndexForDeletion + 1)+" - "+(employeeCount)+") : ");
            int id = sc.nextInt();
        
            if(id <= startingIndexForDeletion || id > employeeCount){
                throw new InvalidIdException();
            }else if(employees[id-1] == null){
                System.out.println("No employee present with id "+id);
                return true;
            }else{
                Employee.display(employees[id-1]);
                System.out.println("Do you really want to delete this employee?");
                System.out.println("____________________________________________");
                System.out.println("1. yes");
                System.out.println("2. no");
                int yesNo = sc.nextInt();
                if(yesNo == 1){
                    employees[id-1] = null;
                    System.out.println("Employee deleted successfully!");
                    return true;
                }else{
                    System.out.println("Exiting....");
                    return true;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter numbers only...");
            return true;
        }catch(InvalidIdException e){
            //printing from InvalidIdException's constructor;
            return false;
        }
    }

    
    public static void raiseSalary(){
        for(Employee emp : employees){
            if(emp != null) emp.raiseSalary();
        }
    }


    public static void display(){
        for(Employee emp : employees){
            if(emp != null) Employee.display(emp);
        }
    }


    public static boolean createMenu(){
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("________________________________________");
            System.out.println("1. Clerk");
            System.out.println("2. Programmer");
            System.out.println("3. Manager");
            System.out.println("4. Exit");
            System.out.println("________________________________________");
            System.out.print("Enter choice : ");
            int type = sc.nextInt();
        
            if(type == 1){
                employees[employeeCount] =  new Clerk(employeeCount+1);
                employeeCount++;
            }else if(type == 2){
                employees[employeeCount] =  new Programmer(employeeCount+1);
                employeeCount++;
            }else if(type == 3){
                employees[employeeCount] =  new Manager(employeeCount+1);
                employeeCount++;
            }else if(type == 4){
                return false;
            }else{
                throw new InvalidChoiceException();
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter a number..");
            return true;
        }catch(InvalidChoiceException e){
            //printing from InvalidChoiceException's constructor..
            return true;
        }
        return true;
    }
}
