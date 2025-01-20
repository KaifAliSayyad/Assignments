import java.io.IOException;

public abstract class Race {
    private static Biker[] bikers;
    public static int totalDistance;
    private static boolean isStarted = false;

    public static int getTotalDistance(){
        return totalDistance;
    }

    public static void setTotalDistance(int dist){
        totalDistance = dist;
    }

    public static void declareBikers(int numberOfBikers){
        bikers = new Biker[numberOfBikers];
    }

    public void setBiker(int index, Biker biker){
        bikers[index] = biker;
    }

    public static boolean getIsStarted(){
        return isStarted;
    }

    public static void setIsStarted(){
        isStarted = true;
    }
    
    public static void printBikers(){
        //For clearing the console
        System.out.println("\033\143");

        for(Biker biker : bikers){
            for(int i = 0 ; i < Math.max(totalDistance - biker.getRemainingDistance(), totalDistance) ; i++){
                System.out.print(" ");
            }
            System.out.println(biker.getName() + "|");
        }
        for(int i = 0 ; i < totalDistance + 10; i++){
            System.out.print("- ");
        }
        System.out.println("\n");
    }

    public static void getReport(){
        //First calc ranks then arrange them in descending order
        for(int i = 0 ; i < bikers.length ; i++){
            for(int j = 0 ; j < bikers.length ; j++){
                if(bikers[i].getTimeTaken() < bikers[j].getTimeTaken()){
                    Biker temp = bikers[i];
                    bikers[i] = bikers[j];
                    bikers[j] = temp;
                }
            }
        }

        System.out.println("Biker Name\t| Start Time\t| End Time\t| Time Taken\t| Rank");
        System.out.println("____________________________________________________________________________");
        for(int i = 0 ; i < bikers.length ; i++){
            System.out.println(bikers[i].getName() + "\t| " + bikers[i].getStartTime() + "\t| " + bikers[i].getEndTime() + "\t| " + bikers[i].getTimeTaken() + "\t| " + (i + 1));
            System.out.println("____________________________________________________________________________");
        }
        
    }

}
