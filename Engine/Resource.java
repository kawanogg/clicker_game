package Engine;
import Threads.addCurrency;

import java.util.ArrayList;

public class Resource {
    private int pedros_currency;
    private int pps;          //Pedros por segundo.
    private static ArrayList<Entity> entities = new ArrayList<Entity>();

    Resource() {
        this.pedros_currency = 0;
        this.pps = 0;
        addCurrencyThread();
        update_ppsThread();
    }

    /*------------TRATANDO CURRENCY DO PLAYER------------*/

    public void addCurrencyThread() {
        Thread currencyThread = new addCurrency(this);
        currencyThread.start();
    }

    public int getCurrency() {
        return this.pedros_currency;
    }
    
    public void addCurrency(int amount) {
        this.pedros_currency += amount;
    }

    /*---------------------------------------------------*/

    public static void addEntity(Entity entity) {
        entities.add(entity);
    }


    /*---------TRATANDO PEDROS POR SEGUNDO (pps)---------*/

    public void update_ppsThread() { //Atualiza o valor de pedros por segundo baseado na qtd de Planeta, Estrela e Cometa.
        Thread updatePPS = new Threads.updatePPS(this);
        updatePPS.start();
    }

    public int getPPS() {
        return this.pps;
    }

    public void setPPS() {
        int sum = 0;
        for (Entity e : entities) {
            sum += e.getTotalProduction();
        }

        this.pps = sum;
    }

    /*---------------------------------------------------*/



}
