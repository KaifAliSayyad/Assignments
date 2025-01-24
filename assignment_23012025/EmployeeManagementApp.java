import java.util.Iterator;

import emp.storage.PersistentStorage;;
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
import emp.utils.EmployeeSearch;
import emp.comparator.EmployeeIDSorter;
import emp.comparator.EmployeeNameSorter;
import emp.comparator.EmployeeAgeSorter;
import emp.comparator.EmployeeSalarySorter;
import emp.comparator.EmployeeDesignationSorter;

import emp.storage.PersistentStorage;


public class EmployeeManagementApp {
    static LinkedHashSet<Employee> employees = new LinkedHashSet<>();
    public static void main(String[] args) {
        employees = loadEmployees();
        // for(Employee e : employees) System.out.println(e.toString());
        boolean isExitted = false;
        try(Scanner sc = new Scanner(System.in);){
            while(!isExitted){
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
                        System.out.println("Total employees present : "+(employees.size()));
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
                        isExitted = true;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            saveEmployees();
        }
    }

    public static boolean search(){
        LinkedHashSet<Employee> temp = new LinkedHashSet<>();
        while(true){
            System.out.println("1. Search using ID");
            System.out.println("2. Search using Designation");
            System.out.println("3. Search using Name");
            System.out.println("4. Exit");
            int choice = Menu.readChoice(4);
            switch (choice) {
                case 1:
                    Employee emp = EmployeeSearch.searchUsingID(employees);
                    if(emp != null) Employee.display(emp);
                    else{
                        System.out.println("No employee exists with this id!!!");
                        return true;
                    }
                    break;
                case 2:
                    temp = EmployeeSearch.searchUsingDesignation(employees);
                    if(temp.size() == 0){
                        System.out.println("No employees present with selected Designation..");
                        break;
                    }else{
                        Iterator i = temp.iterator();
                        while(i.hasNext()){
                            Employee.display((Employee)i.next());
                        }
                    }
                    break;
                case 3:
                    temp = EmployeeSearch.searchUsingName(employees);
                    if(temp.size() == 0){
                        System.out.println("No employees present with selected Designation..");
                        break;
                    }else{
                        Iterator i = temp.iterator();
                        while(i.hasNext()){
                            Employee.display((Employee)i.next());
                        }
                    }
                    break;
                case 4:
                    return false;
            }
            return true;
        }
    }

    public static void display(){
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Designation");
        System.out.println("3. Sort by Name");
        System.out.println("4. Sort by Age");
        System.out.println("5. Sort by Salary");
        System.out.println("6. Input Order");
        int choice = new Scanner(System.in).nextInt();
        ArrayList<Employee> array = new ArrayList<>(employees); 
        switch(choice){
            case 1 -> Collections.sort(array, new EmployeeIDSorter());
            case 2 -> Collections.sort(array, new EmployeeDesignationSorter());
            case 3 -> Collections.sort(array, new EmployeeNameSorter());
            case 4 -> Collections.sort(array, new EmployeeAgeSorter());
            case 5 -> Collections.sort(array, new EmployeeSalarySorter());
            default -> {
                
            }
        };

        for(Employee emp : array){
            Employee.display(emp);
        }
    }

    public static boolean delete(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter the id of the employee you want to delete : ");
            String id = sc.nextLine();
            Employee emp = EmployeeSearch.searchUsingID(employees, id);
            if(emp != null){
                if(emp.getDesignation().equals("CEO")){
                    System.out.println("Cannot delete CEO!!");
                    return true;
                }
                
                //Logic to delete this Employee
                employees.remove(emp);
                // saveEmployees();
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

        Iterator i = employees.iterator();
        while(i.hasNext()){
            ((Employee)i.next()).raiseSalary();
        }
        System.out.println("Salary of all the Employees has been raised!!");
        // saveEmployees();
    }


    public static void displayAll(){
        if(employees.size() == 0){
            System.out.println("No employees present to display.");
            return;
        }
        
        Iterator i = employees.iterator();
        while(i.hasNext()){
            Employee.display((Employee)i.next());
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
            Employee emp = null;
            String newEmpId;
            if(type == 1){
                if(!Employee.getBoolean()){
                    System.out.println("Please create a CEO first..");
                    return true;
                }
                newEmpId = Menu.readId(employees, 1);
                emp = Clerk.getObject(newEmpId);
                employees.add(emp);
                return true;
            }else if(type == 2){
                if(!Employee.getBoolean()){
                    System.out.println("Please create a CEO first..");
                    return true;
                }
                newEmpId = Menu.readId(employees, 2);
                emp = Programmer.getObject(newEmpId);
                employees.add(emp);
                return true;
            }else if(type == 3){
                if(!Employee.getBoolean()){
                    System.out.println("Please create a CEO first..");
                    return true;
                }
                newEmpId = Menu.readId(employees, 3);
                emp = Manager.getObject(newEmpId);
                employees.add(emp);
                return true;
            }else if(type == 4){
                newEmpId = Menu.readId(employees, 4);
                emp = Ceo.getObject(newEmpId);
                employees.add(emp);
                return true;
            }else if(type == 5){
                return false;
            }else{
                throw new InvalidChoiceException();
            }

            //Saving the Employee
            // if(emp != null) saveEmployee(emp);


        }catch(InputMismatchException e){
            System.out.println("Please enter a number..");
            return true;
        }catch(InvalidChoiceException e){
            //printing from InvalidChoiceException's constructor..
            return true;
        }
    }

    public static LinkedHashSet<Employee> loadEmployees(){
        return PersistentStorage.loadEmployees();
    }

    public static void saveEmployee(Employee emp){
        boolean successfull = PersistentStorage.saveEmployee(emp);
        if(successfull){
            System.out.println("Employee saved successfully!!!");
        }else{
            System.out.println("Error : Failed to save Employee!!!");
        }
    }

    public static void saveEmployees(){
        boolean successfull = PersistentStorage.saveEmployees(employees);
        if(successfull){
            System.out.println("Employees updated successfully!!!");
        }else{
            System.out.println("Error : Failed to update Employees!!!");
        }
    }
}
