package Engine;

import java.awt.Image;

public class BlackHole extends Entity {
    private Image image_init, image_clicked;
    private int x_init, y_init, x_clicked, y_clicked;


    public BlackHole (int x, int y, int width, int height, double productionRate, double cost, int quantity) {
        super(
                "img/black_hole.png",
                x,
                y,
                width,
                height,
                "Black Holes",
                productionRate,
                cost,
                quantity
        );

        this.x_init = x;
        this.y_init = y;
        this.x_clicked = x - 10;
        this.y_clicked = y - 10;

        this.image_init = image;
        this.image_clicked = image.getScaledInstance(width + 20,  height + 20, Image.SCALE_DEFAULT);

        Resource.addEntity(this);
    } 

    public void resizeWhenClicked () {
        this.image = this.image_clicked;
        this.x = this.x_clicked;
        this.y = this.y_clicked;
        repaint();
    }

    public void resizeBack () {
        image = image_init;
        x = x_init;
        y = y_init;
        

        
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
}