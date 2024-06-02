package Engine;

import java.awt.Graphics;

public class ShopPlanet extends ShopItem {
    public ShopPlanet (int x, int y, int price) {
        super(x, y, new Planet(x+10, y+10, 50, 50), price);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.object.getImage() != null) {
            g.drawImage(this.object.getImage(), x, y, this);
        }
    }
    
}