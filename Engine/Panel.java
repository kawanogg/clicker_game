package Engine;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel extends Paintable {
    private ArrayList<Entity> entities;
    private ArrayList<ShopItem> shop;

    public Panel () {
        this.entities = new ArrayList<Entity>();
        this.shop = new ArrayList<ShopItem>();

        this.shop.add(new ShopItem(400, 0, new Planet(200, 50, 50, 50, 100.0, 50.0, 0)));
        this.addEntity(new BlackHole(50, 50, 100, 100, 10.0, 200.0, 1));

        this.mouseManager();
    }

    public void mouseManager () {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                BlackHole bh = (BlackHole) entities.get(0);

                if (mouseX >= bh.getX() && mouseX <= bh.getX() + bh.getWidth() && mouseY >= bh.getY() && mouseY <= bh.getY() + bh.getHeight()) {
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
            item.paintComponent(g);
        }

        for (Entity entity : this.entities) {
            entity.paintComponent(g);
        }
    }
}