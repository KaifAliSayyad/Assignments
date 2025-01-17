package emp.assignment;
import java.util.*;

public final class Clerk extends Employee{
    private Clerk(int id){
        super(id, 18, 60);
        designation = Designation.valueOf("CLERK");
    }

    // public final void raiseSalary(){
    //     if(employeeCount == 0){
    //         System.out.println("No employees exist to raise salary.");
    //         return;
    //     }
    //     setSalary(2000);
    // }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Clerk getObject(int id){
        if(!getBoolean()){
            System.out.println("Please create a CEO first..");
            return null;
        }
        return new Clerk(id);
    }
}