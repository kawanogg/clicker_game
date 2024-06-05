package Engine;
import Threads.addCurrency;

public class Player {
    private int pedros_currency;
    private int planet_count; // +1 pedros por segundo.
    private int star_count;   // +3 pedros por segundo.
    private int comet_count;  // +5 pedros por segundo.
    private int pps;          //Pedros por segundo.

    public Player() {
        this.pedros_currency = 0;
        this.planet_count = 0;
        this.star_count = 0;
        this.comet_count = 0;
        this.pps = 0;
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

    public void addPlanet() {
        this.planet_count++;
    }

    public void removePlanet() {
        this.planet_count--;
    }

    public int getPlanetCount() {
        return this.planet_count;
    }

    public void addStar() {
        this.star_count++;
    }

    public void removeStar() {
        this.star_count--;
    }

    public int getStarCount() {
        return this.star_count;
    }

    public void addComet() {
        this.comet_count++;
    }

    public void removeComet() {
        this.comet_count--;
    }

    public int getCometCount() {
        return this.comet_count;
    }

}
