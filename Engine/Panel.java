package Engine;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel extends JPanel {
    private ArrayList<Entity> entities;
    private ArrayList<ShopItem> shop;

    public Panel () {
        this.entities = new ArrayList<Entity>();
        this.shop = new ArrayList<ShopItem>();

        this.setLayout(null);

        this.addEntity(new BlackHole(50, 50, 100, 100, 0, 0, 0));
        
        this.shop.add(new ShopItem(400, 0, 200, 100,  new Planet(200, 50, 50, 50, 100.0, 50.0, 1)));
        this.shop.add(new ShopItem(400, 100, 200, 100, new Planet(200, 50, 50, 50, 100.0, 50.0, 1)));

        this.add(this.shop.get(0).getButton());
        this.setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                BlackHole bh = (BlackHole) entities.get(0);

                if (mouseX >= bh.getX() && mouseX <= bh.getX() + bh.getWidth() && mouseY >= bh.getY() && mouseY <= bh.getY() + bh.getHeight()) {
                    //bh.addCurrency(1);
                    
                    bh.resizeWhenClicked();
                    repaint();

                    ActionListener task = new ActionListener() {
                        public void actionPerformed (ActionEvent evt) {
                            bh.resizeBack();
                            repaint();
                        }
                    };

                    Timer timer = new Timer(50, task);
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });
    }

    public void addEntity(Entity newEntity) {
        this.entities.add(newEntity);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ShopItem item : this.shop) {
            g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
            g.drawImage(item.getImage(), item.getX() + 10, item.getY() + 25, this);
        }

        for (Entity entity : this.entities) {
            g.drawImage(entity.getImage(), entity.getX(), entity.getY(), this);
        }
    }
}