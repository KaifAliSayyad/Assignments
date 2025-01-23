package emp.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import emp.assignment.Designation;
import emp.utils.Menu;
import java.util.Scanner;

import emp.assignment.Employee;

public class EmployeeSearch{
    public static Employee searchUsingID(LinkedHashSet<Employee> employees){
        System.out.print("Enter the Id of the Employee  : ");
        String id = new Scanner(System.in).nextLine();
        
        ArrayList<Employee> arr = employees.toArray();
        Collections.sort(arr);
        Employee emp = Collections.binarySearch(arr, id);

        return emp;
    }

    public static Employee searchUsingID(LinkedHashSet<Employee> employees, String id){
        Iterator<Employee> i = employees.iterator();
        while(i.hasNext()){
            if(i.next().getId().equals(id)) return (Employee)i;
        }

        return null;
    }

    public static LinkedHashSet<Employee> searchUsingDesignation(LinkedHashSet<Employee> employees){
        Designation[] designations = Designation.values();
        for(int i = 0; i < designations.length ; i++){
            System.out.println((i+1)+". "+designations[i]);
        }
        
        int choice = Menu.readChoice(designations.length);
        Designation selectedDesignation = designations[choice];

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