package Threads;
import Engine.Resource;

public class addCurrency extends Thread{

    private Resource resource;

    public addCurrency(Resource resource){
        this.resource = resource;
    }
    
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                resource.addCurrency(resource.getPPS());
                System.out.println("Currency: " + resource.getCurrency());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}