package emp.assignment;
import java.util.*;

public final class Clerk extends Employee{
    public Clerk(int id){
        super(id);
        designation = Designation.valueOf("CLERK");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 2000;
    }
}