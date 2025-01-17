public class Biker extends Race implements Runnable{
    private float startTime;
    private float endTime;
    private int speed;
    private int distRemaining;

    public Biker(){        
        speed = (int)(Math.random() * (totalDistance / 4));
    }


}
