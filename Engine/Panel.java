package Engine;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Panel extends Paintable {
    private Player player;
    private ArrayList<Entity> entities;
    private ArrayList<ShopItem> shop;

    public Panel () {
        this.entities = new ArrayList<Entity>();
        this.shop = new ArrayList<ShopItem>();
        this.player = new Player();
    }

    public void addEntity(Entity newEntity) {
        this.entities.add(newEntity);
    }

    public void startPanel () {
        this.shop.add(new ShopPlanet(400, 0, 100));
        this.addEntity(new BlackHole(50, 50, 100, 100, player));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ShopItem item : this.shop) {
            item.paintComponent(g);
        }

        for (Entity entity : this.entities) {
            entity.paintComponent(g);
        }
    }
}