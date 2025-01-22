package emp.assignment;
import java.util.*;

public final class Ceo extends Employee{
    private static Ceo c = null;
    private Ceo(String id){
        super(id, 25, 75);
        designation = Designation.valueOf("CEO");
        setBoolean();
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
}