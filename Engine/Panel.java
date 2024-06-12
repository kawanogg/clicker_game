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
    private GameState gameState;
    private Planet planet;
    private Star star;
    private Comet comet;

    public Panel(Player player) throws IOException {
        this.player = player;

        this.entities = new ArrayList<Entity>();
        this.shop = new ArrayList<ShopItem>();
        this.currencyLabel = new JLabel();
        this.currencyLabel = new JLabel("Currency: " + player.getCurrency());
        this.currencyLabel.setBounds(30, 30, 1000, 50);
        this.currencyLabel.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        this.currencyLabel.setForeground(Color.white);

        this.gameName = new JLabel("SPACE CLICKER");
        this.gameName.setBounds(110, 350, 500, 50);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("../Font/Andromeda.ttf"));
            this.gameName.setFont(customFont.deriveFont(Font.PLAIN, 45));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.gameName.setForeground(Color.darkGray);

        this.setLayout(null);
        this.setBackground(Color.black);

        this.addEntity(new BlackHole(100, 120, 200, 200, player));

        this.planet = new Planet(180, 50, 60, 60);
        this.star = new Star(50, 80, 65, 65);
        this.comet = new Comet(285, 70, 80, 80);

        this.shop.add(new ShopItem(400, 0, 200, 100, 10, planet, player));
        this.shop.add(new ShopItem(400, 100, 200, 100, 20, star, player));
        this.shop.add(new ShopItem(400, 200, 200, 100, 30, comet, player));

        if (this.player.getPlanetCount() > 0) {
            addEntity(planet);
        }
        if (this.player.getCometCount() > 0) {
            addEntity(comet);
        }
        if (this.player.getStarCount() > 0) {
            addEntity(star);
        }

        for (ShopItem item : shop) {
            item.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (player.getCurrency() >= item.getPrice()) {
                        if (!entities.contains(item.getObject())) {
                            addEntity(item.getObject());
                        }
                        player.subtractCurrency(item.getPrice());
                        player.addObject(item.getObject().getId());
                        repaint();
                    }
                }
            });
            this.add(item.getButton());
            this.add(item.getLabel());
        }

        this.add(this.currencyLabel);
        this.add(this.gameName);
        this.setVisible(true);

        this.startPrintCurrency();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                BlackHole bh = (BlackHole) entities.get(0);

                if (mouseX >= bh.getX() && mouseX <= bh.getX() + bh.getWidth() && mouseY >= bh.getY()
                        && mouseY <= bh.getY() + bh.getHeight()) {
                    player.addCurrency(1);
                    bh.resizeWhenClicked();
                    repaint();

                    ActionListener task = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
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
        
        this.gameState = new GameState(30, 10, this.player);
        this.add(gameState.getButton());
        saveGame();
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

    protected void saveGame() {
        this.gameState.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    gameState.saveGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}