package emp.utils;

import java.util.*;
import emp.assignment.Designation;
import emp.utils.Menu;

import emp.assignment.Employee;

public class EmployeeSearch{
    public static Employee searchUsingID(LinkedHashSet<Employee> employees){
        System.out.print("Enter the Id of the Employee  : ");
        String id = new Scanner(System.in).nextLine();
        
        Employee emp = null;
        for(Employee e : employees){
            if(e.getId().equals(id)){
                emp = e;
                break;
            }
        }
        return emp;
    }

    public static Employee searchUsingID(LinkedHashSet<Employee> employees, String id){
        for(Employee e : employees){
            if(e.getId().equals(id)) return e;
        }
        return null;
    }

    public static LinkedHashSet<Employee> searchUsingDesignation(LinkedHashSet<Employee> employees){
        Designation[] designations = Designation.values();

        System.out.println("designations present = "+designations.length);

        for(int i = 0; i < designations.length ; i++){
            System.out.println((i+1)+". "+designations[i]);
        }
        
        int choice = Menu.readChoice(designations.length);
        Designation selectedDesignation = designations[choice-1];

        LinkedHashSet<Employee> out = new LinkedHashSet<>();
        Object[] arr = employees.toArray();
        for(Object emp : arr){
            if(((Employee)emp).getDesignation().equals(selectedDesignation)) out.add((Employee)emp);
        }

        return out;

    }

    public static LinkedHashSet<Employee> searchUsingName(LinkedHashSet<Employee> employees){
        System.out.print("Enter the name of employee(s).");
        String name = Menu.readName();

        LinkedHashSet<Employee> out = new LinkedHashSet<>();
        Object[] arr = employees.toArray();
        for(Object emp : arr){
            if(((Employee)emp).getName().equals(name)) out.add((Employee)emp);
        }

        return out;
    }

}