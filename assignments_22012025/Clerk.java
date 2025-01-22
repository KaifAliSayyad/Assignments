package emp.assignment;
import java.util.*;

public final class Clerk extends Employee{
    private Clerk(String id){
        super(id, 18, 60);
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
}