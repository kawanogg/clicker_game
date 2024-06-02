package Engine;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Paintable extends JPanel {
    public void drawing () {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}