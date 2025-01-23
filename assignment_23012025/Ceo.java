package emp.assignment;
import java.util.*;

public final class Ceo extends Employee{
    private static Ceo c = null;
    private Ceo(String id){
        super(id, 25, 75);
        designation = Designation.valueOf("CEO");
        setBoolean();
    }

    private Ceo(String id, String name, int age, float salary){
        super(id, 18, 60, name, age, salary);
        designation = Designation.valueOf("CEO");
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Ceo getObject(String id){
        if(c == null) c = new Ceo(id);
        else{
            System.out.println("Only one CEO can be created..");
            return null;
        }
        return c;
    }

    public static Ceo getObject(String id, String name, int age, float salary){
        return new Ceo(id, name, age, salary);
    }
}