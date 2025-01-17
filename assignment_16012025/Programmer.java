package emp.assignment;

public final class Programmer extends Employee{

    private Programmer(int id){
        super(id, 21, 60);
        designation = Designation.valueOf("PROGRAMMER");
    }

    // public final void raiseSalary(){
    //     if(employeeCount == 0){
    //         System.out.println("No employees exist to raise salary.");
    //         return;
    //     }
    //     setSalary(5000);
    // }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Programmer getObject(int id){
        if(!getBoolean()){
            System.out.println("Please create a CEO first..");
            return null;
        }
        return new Programmer(id);
    }
}