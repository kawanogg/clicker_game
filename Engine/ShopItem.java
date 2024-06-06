package Engine;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopItem {
    private Entity object;
    private int x, y, width, height;
    private JButton buy;
    private Player player;
    

    public ShopItem (int x, int y, int width, int height, Entity so, Player player) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.object = so;    
        this.player = player;

        this.buy = new JButton("Buy");
        this.buy.setBounds(x + 90, y + 50, 100, 30);
        this.buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                player.addObject(so.getId());
            }
        });
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    public int getWidth () {
        return this.width;
    }

    public int getHeight () {
        return this.height;
    }

    public Image getImage () {
        return this.object.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    }

    public JButton getButton () {
        return this.buy;
    }
}