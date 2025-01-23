package emp.assignment;

public final class Programmer extends Employee{

    private Programmer(String id){
        super(id, 21, 60);
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
}