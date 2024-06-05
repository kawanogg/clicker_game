package Engine;

import javax.swing.JPanel;
import java.awt.Graphics;

public class ShopItem extends Paintable {
    protected Entity object;
    protected int x, y;
    

    public ShopItem (int x, int y, Entity so) {
        this.x = x;
        this.y = y;
        this.object = so;      
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(this.x, this.y, 200, 100);
    }
}