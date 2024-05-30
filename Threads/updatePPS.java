package Threads;
import Engine.Resource;

public class updatePPS extends Thread {

    private Resource resource;

    public updatePPS(Resource resource){
        this.resource = resource;
    }
    
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                resource.setPPS((resource.getPlanetCount() * 1) + (resource.getStarCount() * 3) + (resource.getCometCount() * 5));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
