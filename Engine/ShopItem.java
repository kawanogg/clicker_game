package Engine;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;

public class ShopItem {
    private Entity object;
    private int x, y, width, height, price;
    private JButton buy;
    private JLabel priceLabel;
    @SuppressWarnings("unused")
    private Player player;
    

    public ShopItem (int x, int y, int width, int height, int price, Entity so, Player player) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.price = price;
        this.object = so;    
        this.player = player;

        this.priceLabel = new JLabel();
        this.priceLabel = new JLabel("Price: " + Integer.toString(price));
        this.priceLabel.setBounds(x + 90, y, 100, 50);
        this.priceLabel.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        this.priceLabel.setForeground(Color.white);

        this.buy = new JButton("Buy");
        this.buy.setBounds(x + 90, y + 50, 100, 30);
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

    public int getPrice () {
        return this.price;
    }
    
    public Entity getObject () {
        return this.object;
    }

    public Image getImage () {
        return this.object.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    }

    public JLabel getLabel () {
        return this.priceLabel;
    }

    public JButton getButton () {
        return this.buy;
    }
}