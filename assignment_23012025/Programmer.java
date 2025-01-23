package emp.assignment;

public final class Programmer extends Employee{

    private Programmer(String id){
        super(id, 21, 60);
        designation = Designation.valueOf("PROGRAMMER");
    }

    private Programmer(String id, String name, int age, float salary){
        super(id, 21, 60, name, age, salary);
        designation = Designation.valueOf("PROGRAMMER");
    }

    public final void setMaxAge(int newAge){
        age = newAge;
    }

    public final void setMinAge(int newAge){
        age = newAge;
    }

    public static Programmer getObject(String id){
        if(!getBoolean()){
            System.out.println("Please create a CEO first..");
            return null;
        }
        return new Programmer(id);
    }

    public static Programmer getObject(String id, String name, int age, float salary){
        return new Programmer(id, name, age, salary);
    }
}