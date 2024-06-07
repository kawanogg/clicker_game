package Engine;

import javax.swing.JPanel;
import javax.swing.Timer;

import Threads.printCurrency;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel {
    private ArrayList<Entity> entities;
    private ArrayList<ShopItem> shop;
    private JLabel currencyLabel;
    private JLabel gameName;
    @SuppressWarnings("unused")
    private Player player;

    public Panel (Player player) {
        this.player = player;

        this.entities = new ArrayList<Entity>();
        this.shop = new ArrayList<ShopItem>();
        this.currencyLabel = new JLabel();
        this.currencyLabel = new JLabel("Currency: " + player.getCurrency());
        this.currencyLabel.setBounds(30, 0, 100, 50);
        this.currencyLabel.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        this.currencyLabel.setForeground(Color.white);

        this.gameName = new JLabel("SPACE CLICKER");
        this.gameName.setBounds(110, 350, 500, 50);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("../Font/Andromeda.ttf"));
            this.gameName.setFont(customFont.deriveFont(Font.PLAIN, 45));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.gameName.setForeground(Color.darkGray);

        

        this.setLayout(null);
        this.setBackground(Color.black);

        this.addEntity(new BlackHole(100, 120, 200, 200, player));
        
        this.shop.add(new ShopItem(400, 0, 200, 100, 50, new Planet(200, 50, 50, 50), player));
        this.shop.add(new ShopItem(400, 100, 200, 100, 1000, new Star(50, 75, 50, 50), player));
        this.shop.add(new ShopItem(400, 200, 200, 100, 3000, new Comet(75, 300, 50, 50), player));

        for (ShopItem item : shop) {
            item.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                if (player.getCurrency() >= item.getPrice()) {
                    if (!entities.contains(item.getObject())) { addEntity(item.getObject()); }
                    player.subtractCurrency(item.getPrice());
                    player.addObject(item.getObject().getId());
                    repaint();
                }
            }
        });
            this.add(item.getButton());
        }

        this.add(this.currencyLabel);
        this.add(this.gameName);
        this.setVisible(true);

        this.startPrintCurrency();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                BlackHole bh = (BlackHole) entities.get(0);

                if (mouseX >= bh.getX() && mouseX <= bh.getX() + bh.getWidth() && mouseY >= bh.getY() && mouseY <= bh.getY() + bh.getHeight()) {
                    player.addCurrency(1);
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

    public void startPrintCurrency() {
        new printCurrency(player, this, this.currencyLabel).start();
    }
}