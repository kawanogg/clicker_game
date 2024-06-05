package Engine;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class Entity extends Paintable {
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

    public double getProductionRate(){
        return productionRate;
    }

    public double getCost(){
        return cost;
    }

    public int getQuantity(){
        return quantity;
    }

    public double updateProductionRate(double value){
        return value * productionRate;
    }

    public int buy(){
        return this.quantity++;
    }

    public int sell(){
        return this.quantity --;
    }

    public double getTotalProduction(){
        return getQuantity() * getProductionRate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(this.image, x, y, this);
        }
    }
}