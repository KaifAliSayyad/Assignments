import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.*;
import emp.assignment.Employee;
import emp.assignment.Clerk;
import emp.assignment.Programmer;
import emp.assignment.Manager;
import emp.assignment.Ceo;
import emp.exceptions.InvalidAgeException;
import emp.exceptions.InvalidChoiceException;
import emp.exceptions.InvalidIdException;
import emp.utils.Menu;


public class EmployeeManagementApp {
    static LinkedHashMap<String, Employee> employees = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Exit");
            System.out.println("________________________________________");
            int choice = Menu.readChoice(6);
            switch (choice) {
                case 1:
                    while(createMenu());
                    System.out.println("Total employees added : "+(employees.size()));
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
                    while(search());
                    break;
                case 6: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static boolean search(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter the ID of the Employee you want details : ");
            String id = sc.nextLine();
            if(employees.containsKey(id)){
                Employee.display(((Employee)employees.get(id)));
                return false;
            }else{
                System.out.println("ID does not exists!!");
                return true;
            }
        }
    }
    public static boolean delete(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter the id of the employee you want to delete : ");
            String id = sc.nextLine();
            if(employees.containsKey(id)){
                if(Employee.getDesignation(((Employee)employees.get(id))).equals("CEO")){
                    System.out.println("Cannot delete CEO!!");
                    return true;
                }
                employees.remove(id);
                return false;
            }else{
                System.out.println("No employee present with ID : "+id);
                return true;
            }
        }
    }

    
    public static void raiseSalary(){
        if(employees.size() == 0){
            System.out.println("No employees present to raise salary.");
            return;
        }

        Set<String> keys = employees.keySet();
        for(String key : keys){
            ((Employee)employees.get(key)).raiseSalary();
        }
    }


    public static void display(){
        if(employees.size() == 0){
            System.out.println("No employees present to display.");
            return;
        }
        
        Set<String> keys = employees.keySet();
        for(String key : keys){
            Employee.display(((Employee)employees.get(key)));
        }
    }


    public static boolean createMenu(){
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("________________________________________");
            System.out.println("1. Clerk");
            System.out.println("2. Programmer");
            System.out.println("3. Manager");
            System.out.println("4. Ceo");
            System.out.println("5. Exit");
            System.out.println("________________________________________");
            int type = Menu.readChoice(5);
            
            String newEmpId;
            if(type == 1){
                if(!Employee.getBoolean()){
                    System.out.println("Please create a CEO first..");
                    return true;
                }
                System.out.print("Enter the id of the new Clerk : ");
                newEmpId = Menu.readId(employees);
                employees.put(newEmpId, Clerk.getObject(newEmpId));
                return true;
            }else if(type == 2){
                if(!Employee.getBoolean()){
                    System.out.println("Please create a CEO first..");
                    return true;
                }
                System.out.print("Enter the id of the new Programmer : ");
                newEmpId = Menu.readId(employees);
                employees.put(newEmpId, Programmer.getObject(newEmpId));
                return true;
            }else if(type == 3){
                if(!Employee.getBoolean()){
                    System.out.println("Please create a CEO first..");
                    return true;
                }
                System.out.print("Enter the id of the new Manager : ");
                newEmpId = Menu.readId(employees);
                employees.put(newEmpId, Manager.getObject(newEmpId));
                return true;
            }else if(type == 4){
                System.out.print("Enter the id of the new CEO : ");
                newEmpId = Menu.readId(employees);
                employees.put(newEmpId, Ceo.getObject(newEmpId));
                return true;
            }else if(type == 5){
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
    }
}
