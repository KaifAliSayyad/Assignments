package emp.assignment;
import java.util.*;

public final class Clerk extends Employee{
    public Clerk(int id){
        super(id, 18, 60);
        designation = Designation.valueOf("CLERK");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 2000;
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }
}