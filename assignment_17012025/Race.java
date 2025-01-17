
public abstract class Race {
    private static Biker[] bikers;
    public static int totalDistance;

    public static int getTotalDistance(){
        return totalDistance;
    }

    public static void setTotalDistance(int dist){
        totalDistance = dist;
    }

    public static void declareBikers(int numberOfBikers){
        bikers = new Biker[numberOfBikers];
    }

    
}
