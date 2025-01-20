public class Biker extends Race implements Runnable{
    private long startTime;
    private long endTime;
    private int speed;
    private int distRemaining;
    private String name;
    private static int index = 0;
    private long timeTaken;

    private Biker(String name){
        this.name = name;
        this.speed = (int)(Math.random() * totalDistance/4) + (totalDistance / 10);
        distRemaining = totalDistance;
        setBiker(index++, this);
    }

    public void run(){
        startTime = System.currentTimeMillis();
        while(!Race.getIsStarted()){
            System.out.println("Waiting for eveyone to start...");
            Thread.sleep(2000);
        }

        while(distRemaining > 0){
            synchronized(this){
                Race.printBikers();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            distRemaining -= speed;
            
        }

        endTime = System.currentTimeMillis();
        timeTaken = endTime - startTime;
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

    public long getStartTime(){
        return startTime;
    }

    public long getEndTime(){
        return endTime;
    }

    public long getTimeTaken(){
        return timeTaken;
    }
}
