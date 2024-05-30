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
    protected String name;
    protected double productionRate;
    protected double cost;
    protected int quantity;

    public Entity(String imagePath, int x, int y, int width, int height, String name, double productionRate, double cost, int quantity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.productionRate = productionRate;
        this.cost = cost;
        this.quantity = quantity;

        try {
            BufferedImage buffered_image = ImageIO.read(new File(imagePath));
            this.image = buffered_image.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setSize(new Dimension(x, y));

    }

    protected double getProductionRate(){
        return productionRate;
    }

    protected double getCost(){
        return cost;
    }

    protected int getQuantity(){
        return quantity;
    }

    protected double updateProductionRate(double value){
        return value * productionRate;
    }

    protected int buy(int quantity){
        return this.quantity += quantity;
    }

    protected int sell(int quantity){
        return this.quantity -= quantity;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(this.image, x, y, this);
        }
    }
}