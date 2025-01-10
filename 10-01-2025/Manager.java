package emp.assignment;


public final class Manager extends Employee{
    public Manager(int id){
        super(id);
        designation = Designation.valueOf("MANAGER");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 15000;
    }
}