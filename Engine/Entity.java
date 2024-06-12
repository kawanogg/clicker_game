package Engine;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public abstract class Entity {
    protected Image image;
    protected int x, y, width, height, id;

    public Entity(String imagePath, int x, int y, int width, int height, int id) throws ImageNotFoundException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;

        try {
            BufferedImage buffered_image = ImageIO.read(new File(imagePath));
            this.image = buffered_image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch (Exception e) {
            if (!new File(imagePath).exists()) {
                throw new ImageNotFoundException(imagePath);
            }
        }
    }

    public Image getImage () {
        return this.image;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    public int getWidth () {
        return this.width;
    }

    public int getHeight () {
        return this.height;
    }

    public int getId () {
        return this.id;
    }
}