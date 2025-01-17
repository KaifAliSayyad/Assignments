package emp.assignment;


public final class Manager extends Employee{

    private static int countOfManagers = 0;

    private Manager(int id){
        super(id, 30, 60);
        designation = Designation.valueOf("MANAGER");
    }

    // public final void raiseSalary(){
    //     if(employeeCount == 0){
    //         System.out.println("No employees exist to raise salary.");
    //         return;
    //     }
    //     setSalary(15000);
    // }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Manager getOjbect(int id){
        if(!getBoolean()){
            System.out.println("Please create a CEO first..");
            return null;
        }
        if(countOfManagers < 10){
            countOfManagers++;
            return new Manager(id);
        }else{
            System.out.println("Maximum number of managers reached!!");
            return null;
        } 
            
    }
}