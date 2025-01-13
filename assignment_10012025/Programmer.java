package emp.assignment;

public final class Programmer extends Employee{
    public Programmer(int id){
        super(id);
        designation = Designation.valueOf("PROGRAMMER");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 5000;
    }
}