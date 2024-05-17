import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Entity extends JPanel {
    private BufferedImage image;
    private int x, y, width, height;
    private double productionRate;
    private double cost;
    private int quantity;

    public Entity(String imagePath, int x, int y, int width, int height, double productionRate, double cost, int quantity) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.productionRate = productionRate;
        this.cost = cost;
        this.quantity = quantity;
    }

    public double getProductionRate() {
        return this.productionRate;
    }
    public double getCost() {
        return this.cost;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public int buy(int quantity) {
        return this.quantity + quantity;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, x, y, this);
        }
    }
}