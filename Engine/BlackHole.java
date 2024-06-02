package Engine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.Timer;

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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    resizeWhenClicked();
                }
            }
        });

        Resource.addEntity(this);
    } 

    public void resizeWhenClicked () {
        this.image = this.image_clicked;
        this.x = this.x_clicked;
        this.y = this.y_clicked;
        repaint();

        ActionListener task = new ActionListener() {
            public void actionPerformed (ActionEvent evt) {
                image = image_init;
                x = x_init;
                y = y_init;
                repaint();
            }
        };

        Timer timer = new Timer(50, task);
        timer.setRepeats(false);
        timer.start();
    }
}