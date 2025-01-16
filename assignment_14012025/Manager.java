package emp.assignment;


public final class Manager extends Employee{
    public Manager(int id){
        super(id, 30, 60);
        designation = Designation.valueOf("MANAGER");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 15000;
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }
}