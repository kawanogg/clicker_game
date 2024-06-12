package Threads;
import Engine.Player;

public class addCurrency extends Thread{

    private Player player;

    public addCurrency(Player player){
        this.player = player;
    }
    
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                player.addCurrency(player.getPPS());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}