package emp.assignment;


public final class Manager extends Employee{

    private static int countOfManagers = 0;

    private Manager(String id){
        super(id, 30, 60);
        designation = Designation.valueOf("MANAGER");
    }

    private Manager(String id, String name, int age, float salary){
        super(id, 30, 60, name, age, salary);
        designation = Designation.valueOf("MANAGER");
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Manager getObject(String id){
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

    public static Manager getObject(String id, String name, int age, float salary){
        return new Manager(id, name, age, salary);
    }
}