import java.util.*;

import emp.storage.DatabaseOperations;
import java.io.*;
import java.sql.*;
import emp.storage.DatabaseOperations;
import emp.utils.Menu;
import emp.utils.EmployeeUtils;


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
                        while(EmployeeUtils.create(designations, departments));
                        break;
                    case 2:
                        while(EmployeeUtils.display());
                        break;
                    case 3:
                    EmployeeUtils.appraisal();
                        break;
                    case 4:
                    EmployeeUtils.search();
                        break;
                    case 5:
                    EmployeeUtils.remove();
                        break;
                    case 6:
                        DatabaseOperations.closeConnection();
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
}
