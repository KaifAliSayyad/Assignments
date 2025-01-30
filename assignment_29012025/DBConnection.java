package emp.storage;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection con = null;
    public static Statement stmt = null;
    private static final String url = "jdbc:postgresql://localhost:5432/empdb";
    private static final String uname = "postgres";
    private static final String password = "tiger";

    private DBConnection(){
        
    }

    static{
        try{
            con = DriverManager.getConnection(url, uname, password);
            stmt = con.createStatement();
        }catch(Exception e){
            System.out.println("Error occured while establishing connection. ERROR : "+e);
        }
    }

    public static boolean closeConnection(){
        try{
            con.close();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println("Error occured while closing connections. ERROR : "+e);
            return false;
        }
    }
}
