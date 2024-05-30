package Engine;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShopItem extends Paintable {
    protected SpaceObject object;
    protected int x, y, price;
    

    public ShopItem (int x, int y, SpaceObject so, int price) {
        this.x = x;
        this.y = y;
        this.object = so;
        this.price = price;   

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    
                    
                }
            }
        });    
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(this.x, this.y, 200, 100);
    }
}