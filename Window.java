import javax.swing.JFrame;

public class Window extends JFrame {
    // Atributos

    // Métodos
    public Window (int width, int height, String title) {
        super(title);
        this.setSize(width, height);
    }
}