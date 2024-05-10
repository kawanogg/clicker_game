import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class Entity {
    
    float x, y;
    JPanel entityPanel; // Estudar-lo-ei

    @SuppressWarnings("unused")
    private Image img;

    public Entity(float x, float y, File imgPath) {
        this.x = x;
        this.y = y;

        try {
            this.img = ImageIO.read(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Método draw??

}
