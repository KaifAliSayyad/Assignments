import java.util.Scanner;

public class Inputs {
    public static int readNumberOfBikers(){
        while(true){
            System.out.print("Enter then number of Bikers : ");
            int numberOfBikers = new Scanner(System.in).nextInt();
            if(numberOfBikers > 2){
                sc.close();
                return numberOfBikers;
            }
            else{
                System.out.println("There should be more than one biker..");
            }
        }
    }

    public static int readTotalDistance(){
        while(true){
            System.out.print("Enter the total distance in units (10,000 - 20,000) : ");
            int totalDistance = new Scanner(System.in).nextInt();
            if(totalDistance < 10000 || totalDistance > 20000){
                System.out.println("Please enter valid distance...");
            }else{
                sc.close();
                return totalDistance;
            }
        }
    }
}
