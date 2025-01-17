public class RoadRash {
    public static void main(String[] args) {
        int numberOfBikers = Inputs.readNumberOfBikers();
        int totalDistance = Inputs.readTotalDistance();

        Race.declareBikers(numberOfBikers);
        Race.setTotalDistance(totalDistance);

        
    }
}
