package Engine;
import Threads.addCurrency;

import java.io.Serializable;

public class Player implements Serializable {
    private int pedros_currency;
    private int[] object_counter;       // [0] Planet >> +1 pedros por segundo. [1] Star >> +3 pedros por segundo. [2] Comet >> +5 pedros por segundo.
    private int pps;                    //Pedros por segundo.

    public Player() {
        this.pedros_currency = 0;
        this.object_counter = new int[3];
        this.pps = 0;
    }

    public void initializeComponents() {
        addCurrencyThread();
        update_ppsThread();
    }

    /*------------TRATANDO CURRENCY DO PLAYER------------*/

    public void addCurrencyThread() {
        Thread currencyThread = new addCurrency(this);
        currencyThread.start();
    }

    public synchronized int getCurrency() {
        return this.pedros_currency;
    }
    
    public synchronized void addCurrency(int amount) {
        this.pedros_currency += amount;
    }

    public synchronized void subtractCurrency(int amount) {
        this.pedros_currency -= amount;
    }

    /*---------------------------------------------------*/


    /*---------TRATANDO PEDROS POR SEGUNDO (pps)---------*/

    public void update_ppsThread() { //Atualiza o valor de pedros por segundo baseado na qtd de Planeta, Estrela e Cometa.
        Thread updatePPS = new Threads.updatePPS(this);
        updatePPS.start();
    }

    public int getPPS() {
        return this.pps;
    }

    public void setPPS(int pps) {
        this.pps = pps;
    }

    /*---------------------------------------------------*/

    //Getters e Setters.

    public void addObject (int id) {
        this.object_counter[id]++;
    }

    public int[] getObjectCounter() {
        return this.object_counter;
    }

    public int getPlanetCount() {
        return this.object_counter[0];
    }

    public int getStarCount() {
        return this.object_counter[1];
    }

    public int getCometCount() {
        return this.object_counter[2];
    }

}
