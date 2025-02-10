import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.CountDownLatch;

import static java.time.temporal.ChronoUnit.MILLIS;

import static java.time.temporal.ChronoUnit.SECONDS;
public class Biker extends Race implements Runnable{
    private LocalTime startTime;
    private LocalTime endTime;
    private long timeTaken;
    private int speed;
    private int distRemaining;
    private String name;
    private static int index = 0;
    private CountDownLatch latch;
    private CountDownLatch waitLatch;

    private Biker(String name, CountDownLatch latch, CountDownLatch waitLatch){
        this.name = name;
        this.speed = (int)(Math.random() * totalDistance/4) + (totalDistance / 10);
        distRemaining = totalDistance;
        this.latch = latch;
        this.waitLatch = waitLatch;
        setBiker(index++, this);
    }

    public void run(){
        try{
            waitLatch.countDown();
            if(waitLatch.getCount() > 0) System.out.println("Biker "+name+" is waiting for all the bikers to get ready!!");
            waitLatch.await();
        }catch(InterruptedException e){
            System.out.println("Error..");
        }

        startTime = LocalTime.now();
        while(distRemaining > 0){
                Race.printBikers();
            try{
                distRemaining -= speed;
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        endTime = LocalTime.now();
        timeTaken = startTime.until(endTime, MILLIS);
        distRemaining = 0;
        latch.countDown();
    }

    public int getRemainingDistance(){
        return distRemaining;
    }

    public static Biker getObject(CountDownLatch latch, CountDownLatch waitLatch){
        String name = Inputs.getBikerName(index);
        return new Biker(name, latch, waitLatch);
    }

    public String getName(){
        return name;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public long getTimeTaken(){
        return timeTaken;
    }
}
