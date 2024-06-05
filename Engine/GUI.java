package Engine;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GUI {
    private Panel panel;
    private Frame frame;

    public GUI () {
        this.frame = new Frame();
        this.panel = new Panel();
    }

    public void openFrame () {
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
}