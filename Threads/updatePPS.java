package Threads;
import Engine.Player;

public class updatePPS extends Thread {

    private Player player;

    public updatePPS(Player player){
        this.player = player;
    }
    
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                player.setPPS((player.getPlanetCount() * 1) + (player.getStarCount() * 3) + (player.getCometCount() * 5));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
