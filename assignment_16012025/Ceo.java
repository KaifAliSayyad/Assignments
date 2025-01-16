package emp.assignment;
import java.util.*;

public final class Ceo extends Employee{
    private static Ceo c = null;
    private Ceo(int id){
        super(id, 25, 75);
        designation = Designation.valueOf("CEO");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 200000;
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Ceo getObject(int id){
        if(c == null) c = new Ceo(id);
        else System.out.println("Only one CEO can be created..");
        return c;
    }
}