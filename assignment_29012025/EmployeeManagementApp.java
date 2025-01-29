import java.util.*;
import java.io.*;
import java.sql.*;
import emp.storage.DatabaseOperations;
import emp.utils.Menu;


public class EmployeeManagementApp {
    private static Map<Integer, String> designations = new HashMap<>();
    private static Map<Integer, String> departments = new HashMap<>();
    
    public static void main(String[] args){
        designations = DatabaseOperations.loadDesignations();
        departments = DatabaseOperations.loadDepartments();

        if(designations.size() > 0 && departments.size() > 0){
            while(true){
                System.out.println("1. Create");
                System.out.println("2. Display");
                System.out.println("3. Appraisal");
                System.out.println("4. Search");
                System.out.println("5. Remove");
                System.out.println("6. Exit");
                System.out.print("->");
                int choice = Menu.readChoice(6);
                
                switch (choice) {
                    case 1:
                        while(create());
                        break;
                    case 2:
                        while(display());
                        break;
                    case 3:
                        appraisal();
                        break;
                    case 4:
                        search();
                        break;
                    case 5:
                        remove();
                        break;
                    case 6:
                        System.out.println("Exitting...");
                        System.exit(0);
                    break;
                    default : 
                        System.out.println("Invalid option!!");
                        System.exit(0);
                }
            }
        }else{
            System.exit(0);
        }     
    }

    public static boolean create(){
        Set<Integer> keySet1 = designations.keySet();
        Object[] designation_ids = keySet1.toArray();
        int n = designation_ids.length;
        System.out.println("Select the designation of the Employee. ");
        for(int i = 1 ; i <= n; i++){
            System.out.println(i+". "+designations.get((Integer)(designation_ids[i-1])));
        }
        System.out.println((n+1)+". Others");
        System.out.println((n+2)+". Exit");
        System.out.print("-> ");
        int designation_no = Menu.readChoice(n+2);
        if(designation_no == n+2)
        return false;
        
        Set<Integer> keySet2 = departments.keySet();
        Object[] department_ids = keySet2.toArray();
        int n1 = departments.size();
        System.out.println("Select the department of the Employee. ");
        for(int i = 1 ; i <= n1; i++){
            System.out.println(i+". "+departments.get((Integer)(department_ids[i-1])));
        }
        System.out.print("-> ");
        int department_no = Menu.readChoice(n1);

        int desig_id = -1;
        int depart_id = -1;
        if(designation_no == n+1){
            desig_id = DatabaseOperations.addDesignation();
            designations = DatabaseOperations.loadDesignations();
        }else{
            desig_id = (Integer)(designation_ids[designation_no-1]);
        }

        depart_id = (Integer)(department_ids[department_no-1]);

        if(!DatabaseOperations.add(desig_id, depart_id)){
            return false;
        }else{
            return true;
        }
    }

    public static boolean display(){
        System.out.println("1. By ID");
        System.out.println("2. Name");
        System.out.println("3. Designation");
        System.out.println("4. Age");
        System.out.println("5. Salary");
        System.out.println("6. Exit");
        System.out.print("->");
        int choice = Menu.readChoice(6);
        String order_by = switch(choice){
            case 1 -> "eid";
            case 2 -> "name";
            case 3 -> "designation";    //bug here
            case 4 -> "age";
            case 5 -> "salary";
            case 6 -> {yield null;}
            default -> {yield null;}
        };

        if(order_by == null){
            return false;
        }else{
            List<List<String>> rs = DatabaseOperations.getRecords(order_by);
            printEmployees(rs);
            return true;
        }
    }

    private static void printEmployees(List<List<String>> rs){
        try{
            for(List<String> emp : rs){
                printEmployee(emp);
            }
        }catch(Exception e){
            System.out.println("Error occured while printing!! Try again. ERROR :"+e);
            return;
        }
    }

    private static void printEmployee(List<String> emp){
        System.out.println("-----------------------------------------------------------");
        System.out.println("ID\t\t: "+emp.get(0));
        System.out.println("Name\t\t: "+emp.get(1));
        System.out.println("Age\t\t: "+emp.get(2));
        System.out.println("Salary\t\t: "+emp.get(3));
        System.out.println("Designation\t: "+emp.get(4));
        System.out.println("Department\t: "+emp.get(5));
        System.out.println("-----------------------------------------------------------");
    }

    public static void appraisal(){
        DatabaseOperations.updateSalary();
    }

    public static void search(){
        List<String> employee = DatabaseOperations.searchEmployee();
        printEmployee(employee);
    }
    public static void remove(){
        DatabaseOperations.deleteEmployee();
    }
}
