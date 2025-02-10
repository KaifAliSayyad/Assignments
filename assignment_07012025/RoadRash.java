import java.util.concurrent.CountDownLatch;


import java.util.concurrent.*;
import java.util.*;

public class RoadRash {
    public static void main(String[] args) {
        int numberOfBikers = Inputs.readNumberOfBikers();
        ExecutorService es = Executors.newFixedThreadPool(numberOfBikers);
        CountDownLatch latch = new CountDownLatch(numberOfBikers);
        CountDownLatch waitLatch = new CountDownLatch(numberOfBikers);

        Race.setTotalDistance(Inputs.readTotalDistance());
        Race.declareBikers(numberOfBikers);

        CountDownLatch startTimer = new CountDownLatch(1);
        List<Biker> bikers = new ArrayList<>();
        for(int i = 1;  i <= numberOfBikers ; i++){
            bikers.add(Biker.getObject(latch, waitLatch));
        }


        Thread timer = new Thread(() -> {
                try{
                    for(int i = 1 ; i <= 5 ; i++){
                        System.out.println(i+"...");    
                        Thread.sleep(500);
                    }
                    System.out.println("GO!!!!!!");
                    startTimer.countDown();
                }catch(Exception e){
                    e.printStackTrace();
                }
        });

        timer.start();

        try{
            startTimer.await();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        for(int i = 0 ; i < numberOfBikers ; i++){
            es.submit(bikers.get(i));
        }

        try{
            latch.await();
            es.shutdown();
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
        Race.printBikers();
        Race.getReport();
        
    }
}