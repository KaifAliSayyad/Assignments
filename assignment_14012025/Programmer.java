package emp.assignment;

public final class Programmer extends Employee{
    public Programmer(int id){
        super(id, 21, 60);
        designation = Designation.valueOf("PROGRAMMER");
    }

    public final void raiseSalary(){
        if(employeeCount == 0){
            System.out.println("No employees exist to raise salary.");
            return;
        }
        salary += 5000;
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }
}