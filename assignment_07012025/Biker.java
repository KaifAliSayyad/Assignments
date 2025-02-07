import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalUnit;
import static java.time.temporal.ChronoUnit.SECONDS;
public class Biker extends Race implements Runnable{
    private LocalTime startTime;
    private LocalTime endTime;
    private long timeTaken;
    private int speed;
    private int distRemaining;
    private String name;
    private static int index = 0;

    private Biker(String name){
        this.name = name;
        this.speed = (int)(Math.random() * totalDistance/4) + (totalDistance / 10);
        distRemaining = totalDistance;
        setBiker(index++, this);
    }

    public void run(){
        try{

            synchronized(Race.getLock()){
                if(!Race.getIsStarted()){
                    System.out.println("Waiting for eveyone to start...");
                    Race.getLock().wait();
                }
            }
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
        timeTaken = SECONDS.between(startTime, endTime);
        distRemaining = 0;
    }

    public int getRemainingDistance(){
        return distRemaining;
    }

    public static Biker getObject(){
        String name = Inputs.getBikerName(index);
        return new Biker(name);
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
