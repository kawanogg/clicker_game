package Engine;
import java.util.ArrayList;

import javax.swing.JLabel;

public class GUI {
    private Frame frame;
    private ArrayList<Entity> entities;
    private JLabel currencyLabel;
    private Player player;

    public GUI (Player player) {
        this.frame = new Frame();
        this.entities = new ArrayList<Entity>();
        this.currencyLabel = new JLabel();
        this.player = player;

        this.frame.setVisible(true);
    }

    public void addEntity(Entity newEntity) {
        this.entities.add(newEntity);
        this.frame.add(newEntity);
        this.frame.add(this.currencyLabel);

        this.frame.setVisible(true);

        while(true) {
            this.currencyLabel.setText("Currency: " + player.getCurrency());
            frame.repaint();
        }
    }
}