import java.util.*;
import emp.assignment.Employee;
import emp.assignment.Clerk;
import emp.assignment.Programmer;
import emp.assignment.Manager;

public class EmployeeManagementApp {
    static Employee[] employees = new Employee[100];
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
                    System.out.println("Total employees added : "+employees.length);
                    break;
                
                case 2:
                    display();
                    break;
                
                case 3:
                    raiseSalary();
                    break;
                case 4:
                    System.out.print("Enter the id of the employee you want to delete (1 - 100) : ");
                    int id = sc.nextInt();
                    if(id < 1 || id > 100){
                        System.out.println("Please enter a valid id!");
                        break;
                    }else if(employees[id-1] == null){
                        System.out.println("No employee present with id "+id);
                        break;
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
                            break;
                        }else{
                            System.out.println("Exiting....");
                            break;
                        }
                    }
                case 5: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public static void raiseSalary(){
        for(Employee emp : employees) emp.raiseSalary();
    }

    public static void display(){
        for(Employee emp : employees) Employee.display(emp);
    }
    public static boolean createMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("________________________________________");
        System.out.println("1. Clerk");
        System.out.println("2. Programmer");
        System.out.println("3. Manager");
        System.out.println("________________________________________");
        System.out.print("Enter choice : ");
        int type = sc.nextInt();
        System.out.print("Enter id between (1-100) : ");
        int id = sc.nextInt();
        System.out.println();
        if(id < 1 || id > 100){
            System.out.println("Please enter a valid id!");
            return false;
        }else if(employees[id - 1] != null){
            System.out.print("Employee with same id already present!! Try again.");
            return false;
        }
        if(type == 1){
            employees[id-1] =  new Clerk(id);
        }else if(type == 2){
            employees[id-1] =  new Programmer(id);
        }else if(type == 3){
            employees[id-1] =  new Manager(id);
        }else{
            return false;
        }
        return true;
    }
}
