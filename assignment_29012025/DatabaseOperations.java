package emp.storage;
import java.util.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;

import emp.utils.Menu;
import emp.storage.DBConnection;

public class DatabaseOperations {

    private static final Connection con;
    private static final Statement stmt;

    static{
        con = DBConnection.con;
        stmt = DBConnection.stmt;
    }

    public static boolean add(int desig_id, int department_id){
        String name = Menu.readName();
        int age = Menu.readAge(21, 65);
        float salary = Menu.readSalary();
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        salary = Float.parseFloat(df.format(salary));

        try(PreparedStatement pstmt = con.prepareStatement("insert into employee(name, age, salary, designation, department) values(?, ?, ?, ?, ?)");){
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setFloat(3, (salary));
            pstmt.setInt(4,desig_id);
            pstmt.setInt(5, department_id);

            int affected = pstmt.executeUpdate();
            System.out.println(affected+" employee added to the database.");
            return true;
        }catch(Exception e){
            System.out.println("Error : failed to add employee. "+e);
            return false;
        }
    }

    public static Map<Integer, String> loadDesignations(){
        try{
            ResultSet rs = stmt.executeQuery("select * from designation_table");
            Map<Integer, String> desing = new HashMap<>();
            while(rs.next()){
                desing.put(rs.getInt(1), rs.getString(2));
            }

            return desing;
        }catch(Exception e){
            System.out.println("Some error occured while loading designations. Please restart the app! ERROR : "+e);
            return null;
        }
    }

    public static Map<Integer, String> loadDepartments(){
        try{
            ResultSet rs = stmt.executeQuery("select * from department_table");
            Map<Integer, String> department = new HashMap<>();
            while(rs.next()){
                department.put(rs.getInt(1), rs.getString(2));
            }

            return department;
        }catch(Exception e){
            System.out.println("Some error occured while loading departments. Please restart the app! ERROR : "+e);
            return null;
        }
    }

    public static int addDesignation(){
        int new_id = -1;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
            System.out.print("Enter the name of new designation ");
            String design = Menu.readDesignation();
            int affected = stmt.executeUpdate("insert into designation_table(designation_name) values ('"+design+"')");

            System.out.println(affected+ " designation added successfully!!");
            ResultSet rs = stmt.executeQuery("select designation_id from designation_table where designation_name = '"+design+"'");
            while(rs.next()){
                new_id = rs.getInt(1);
            }

            return new_id;
        }catch(Exception e){
            System.out.println("Some error occured while adding new designation. "+e);
        }
        return new_id;
    }

    public static List<List<String>> getRecords(String order_by){
        try{
            String query = "select e.eid, e.name, e.age, e.salary, ds.designation_name, dp.department_name from employee e join designation_table as ds on e.designation = ds.designation_id join department_table as dp on e.department = dp.department_id order by "+order_by;
            String query1 = "select e.eid, e.name, e.age, e.salary, ds.designation_name, dp.department_name from employee e join designation_table as ds on e.designation = ds.designation_id join department_table as dp on e.department = dp.department_id order by ds.designation";
            if(order_by.equals("designation")) query = query1;
            ResultSet rs = stmt.executeQuery(query);
            List<List<String>> employees = new ArrayList<>();
            while(rs.next()){
                List<String> temp  = new ArrayList<>();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                temp.add(rs.getString(6));
                employees.add(temp);
            }


            return employees;
        }catch(Exception e){
            System.out.println("Cannot fetch records from database. ERROR :"+e);
            return null;
        }
    }

    public static void updateSalary(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
            System.out.print("Enter the ID of the employee you want to increment salary of ");
            int id = Menu.readId();
            ResultSet rs = stmt.executeQuery("select salary from employee where eid = "+id);
            float salary = (float)0.00;

            while(rs.next()) salary = rs.getFloat(1);
            if(salary == 0.00f){
                throw new Exception("Employee not present");
            }
            System.out.print("Enter the increment amount ");
            float inc = Menu.readSalary();
            salary += Math.max(0, inc);

            DecimalFormat df = new DecimalFormat("0.00");
            df.setMaximumFractionDigits(2);

            salary = Float.parseFloat(df.format(salary));

            int affected = stmt.executeUpdate("update employee set salary = "+salary+" where eid = "+id);
            System.out.println("Salary of "+affected+" employee updated.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
            System.out.print("Enter the id of the employee you want to remove ");
            int id = Menu.readId();
            
            ResultSet rs = stmt.executeQuery("select eid from employee where eid ="+id);
            int eid = -1;
            while(rs.next()) eid = rs.getInt(1);
            if(eid == -1) throw new Exception("No employee present..");

            System.out.println("Do you really want to delete this employee? (1. Yes/ 2. No)");
            int confirm = Menu.readChoice(2);
            if(confirm == 1){
                int affected = stmt.executeUpdate("delete from employee where eid = "+id);
                System.out.println(affected+" employee deleted successfully.");
            }else{
                System.out.println("Employee deletetion cancelled!!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> searchEmployee(){
        try{
            System.out.print("Enter the id of the employee you want to search ");
            int id = Menu.readId();
            String query = "select e.eid, e.name, e.age, e.salary, ds.designation_name, dp.department_name from employee e join designation_table as ds on e.designation = ds.designation_id join department_table as dp on e.department = dp.department_id where eid = "+id;
            ResultSet rs = stmt.executeQuery(query);

            List<String> temp = new ArrayList<>();
            while(rs.next()){
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                temp.add(rs.getString(6));
            }

            if(temp.size() == 0) throw new Exception("No employees present..");
            return temp;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean closeConnection(){
        return DBConnection.closeConnection() && Menu.closeReader();
    }

}
