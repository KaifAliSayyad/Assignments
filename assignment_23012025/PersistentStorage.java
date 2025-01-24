package emp.storage;
import java.io.*;
import java.util.LinkedHashSet;

import emp.assignment.Employee;
import emp.assignment.Designation;

// public class PersistentStorage {
//     public static LinkedHashSet<Employee> loadEmployees(){
//         LinkedHashSet<Employee> employees = new LinkedHashSet<>();

//        try(RandomAccessFile raf = new RandomAccessFile("employees.csv", "r");){
           
//             String line = null;
//             while((line = raf.readLine()) != null){
//                 String[] fields = line.split(",");
//                 if(fields[4].equals("CEO")) Employee.setBoolean();

//                 //Fields are in order id, name, age, salary, designation
//                 employees.add(Employee.getObject(fields[0], fields[1], Integer.valueOf(fields[2]), Float.valueOf(fields[3]), Designation.valueOf(fields[4])));
//             }
//        }catch(Exception e){
//             System.out.println(e);
//        }

//        return employees;
//     }

//     public static boolean saveEmployee(Employee emp){
//         //This will append new employee
//         try(PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv", true));){
//             pw.println(emp.toString());
//             pw.flush();
//         }catch(Exception e){
//             System.out.println(e);
//             return false;
//         }

//         return true;
//     }

//     public static boolean saveEmployees(LinkedHashSet<Employee> employees){
//         try(PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv", false));){
//             for(Employee emp : employees){
//                 pw.println(emp.toString());
//             }
//             pw.flush();
//         }catch(Exception e){
//             System.out.println(e);
//         }

//         return true;
//     }
// }


public class PersistentStorage{
    public static LinkedHashSet<Employee> loadEmployees(){
        LinkedHashSet<Employee> employees = new LinkedHashSet<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));){
            Employee emp = null;
            while((emp = (Employee)ois.readObject()) != null){
                employees.add(emp);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // for(Employee e : employees) System.out.println(e.toString());
        return employees;
    }

    // public static boolean saveEmployee(Employee emp){
    //     try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser", true));){
    //         oos.writeObject(emp);
    //     }catch(Exception e){
    //         System.out.println("Error failed to save Employee : "+e);
    //         return false;
    //     }
    //     return true;
    // }

    public static boolean saveEmployees(LinkedHashSet<Employee> employees){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser", true));){
            for(Employee emp : employees){
                oos.writeObject(emp);
            }
        }catch(Exception e){
            System.out.println("Error failed to Save Employees : "+e);
            return false;
        }

        return true;
    }
}