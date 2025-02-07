import java.util.concurrent.ExecutorService;

public class RoadRash {
    public static void main(String[] args) {
        int numberOfBikers = Inputs.readNumberOfBikers();
        ExecutorService es = ExecutorService.newFixedThreadPool(numberOfBikers);
        
        for(int i = 0 ; i < numberOfBikers ; i++){
            es.submit(Biker.getObject());
        }

        
    }
}