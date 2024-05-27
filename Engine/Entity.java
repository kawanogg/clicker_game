package Engine;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Entity extends JPanel {
    protected Image image;
    protected int x, y, width, height;

    public Entity(String imagePath, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        try {
            BufferedImage buffered_image = ImageIO.read(new File(imagePath));
            this.image = buffered_image.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setSize(new Dimension(x, y));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(this.image, x, y, this);
        }
    }
}