public class RoadRash {
    public static void main(String[] args) {
        int numberOfBikers = Inputs.readNumberOfBikers();
        int totalDistance = Inputs.readTotalDistance();

        Biker[] bikers = new Biker[numberOfBikers];
        Thread[] threads = new Thread[numberOfBikers];
        
        Race.declareBikers(numberOfBikers);
        Race.setTotalDistance(totalDistance);

        for(int i = 0 ; i < numberOfBikers ; i++){
            bikers[i] = Biker.getObject();
        }

        Thread count = new Thread(){
            @Override
            public void run(){
                synchronized(this){
                    for(int i = 5 ; i > 0 ; i--){
                        System.out.println(i+"...");
                        try{
                            Thread.sleep(1000);

                        }catch(InterruptedException e){
                            System.out.println("Error...");
                        }
                    }
                    System.out.println("GO!!!");
                }
            }
        };

        count.start();

        try{
            count.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        for(int i = 0 ; i < numberOfBikers ; i++){
            threads[i] = new Thread(bikers[i]);
            threads[i].start();
        }

        Race.setIsStarted();

        for(int i = 0 ; i < numberOfBikers ; i++){
            try{
                threads[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        Race.printBikers();
        Race.getReport();
        
    }
}
