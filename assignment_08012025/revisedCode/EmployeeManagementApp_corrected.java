import java.util.*;

public class EmployeeManagementApp_corrected {
    static Employee[] employees = new Employee[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.println("________________________________________");
            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    while(createMenu());
                    break;
                
                case 2:
                    display();
                    break;
                
                case 3:
                    raiseSalary();
                    break;
                case 4: 
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
        if(type == 1){
            employees[Employee.employeeCount] =  new Clerk();
        }else if(type == 2){
            employees[Employee.employeeCount] =  new Programmer();
        }else if(type == 3){
            employees[Employee.employeeCount] =  new Manager();
        }else{
            return false;
        }
        return true;
    }
}
