import javax.swing.*;

public abstract class Entity extends JFrame {
    
    float x, y;
    private JFrame frame;

    public Entity() {
        this.frame = new JFrame("Retangulo");
        this.frame.pack();
        this.frame.setVisible(true);
    }
    

}
