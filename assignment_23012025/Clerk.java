package emp.assignment;
import java.util.*;

public final class Clerk extends Employee{
    private Clerk(String id){
        super(id, 18, 60);
        designation = Designation.valueOf("CLERK");
    }

    private Clerk(String id, String name, int age, float salary){
        super(id, 18, 60, name, age, salary);
        designation = Designation.valueOf("CLERK");
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Clerk getObject(String id){
        if(!getBoolean()){
            System.out.println("Please create a CEO first..");
            return null;
        }
        return new Clerk(id);
    }

    public static Clerk getObject(String id, String name, int age, float salary){
        return new Clerk(id, name, age, salary);
    }
}