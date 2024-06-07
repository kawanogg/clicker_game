package Threads;

import javax.swing.JLabel;

import Engine.Panel;
import Engine.Player;

public class printCurrency extends Thread {
    
    private Player player;
    private Panel panel;
    private JLabel currencyLabel;

    public printCurrency(Player player, Panel panel, JLabel currencyLabel){
        this.player = player;
        this.panel = panel;
        this.currencyLabel = currencyLabel;
    }
    
    public void run(){
        while(true){
            try{
                Thread.sleep(200);
                this.currencyLabel.setText("Currency: " + player.getCurrency());
                this.panel.repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
