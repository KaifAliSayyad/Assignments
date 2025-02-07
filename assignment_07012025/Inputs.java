import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
    public static int readNumberOfBikers(){
        while(true){
            try{
                System.out.print("Enter then number of Bikers : ");
                int numberOfBikers = new Scanner(System.in).nextInt();

                if(numberOfBikers >= 2){
                    return numberOfBikers;
                }
                else{
                    System.out.println("There should be more than one biker..");
                }
            }catch(InputMismatchException e){
                System.out.println("Only numbers are allowed..");
            }
        }
    }

    public static int readTotalDistance(){
        while(true){
            try{
                System.out.print("Enter the total distance in units (100 - 200) : ");
                int totalDistance = new Scanner(System.in).nextInt();
                if(totalDistance < 100 || totalDistance > 200){
                    System.out.println("Please enter valid distance...");
                }else{
                    return totalDistance;
                }
            }catch(InputMismatchException e){
                System.out.println("Only numbers are allowed...");
            }
        }
    }

    public static String getBikerName(int index){
        while(true){
            try{

                System.out.println("Enter the name of the biker-" + index + " : ");
                String name = new Scanner(System.in).nextLine();
                if(name.length() > 0){
                    if(name.length() > 7){
                        name = name.substring(0, 4) + "...";
                    }else{
                        while(name.length() < 7){
                            name += " ";
                        }
                    }
    
                    return name;
                }else{
                    System.out.println("Please enter a valid name...");
                }
            }catch(InputMismatchException e){
                System.out.println("Only numbers are allowed...");
            }
        }
    }
}
