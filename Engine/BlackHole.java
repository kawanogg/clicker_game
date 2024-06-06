package Engine;

import java.awt.Image;

public class BlackHole extends Entity {
    private Player player;  
    private Image image_init, image_clicked;
    private int x_init, y_init, x_clicked, y_clicked;


    public BlackHole (int x, int y, int width, int height, Player player) {
        super("img/black_hole.png", x, y, width, height);

        this.player = player;

        this.x_init = x;
        this.y_init = y;
        this.x_clicked = x - 10;
        this.y_clicked = y - 10;

        this.image_init = image;
        this.image_clicked = image.getScaledInstance(width + 20,  height + 20, Image.SCALE_DEFAULT);
    } 

    public void resizeWhenClicked () {
        this.image = this.image_clicked;
        this.x = this.x_clicked;
        this.y = this.y_clicked;
    }

    public void resizeBack () {
        this.image = this.image_init;
        this.x = this.x_init;
        this.y = this.y_init;
    }
}