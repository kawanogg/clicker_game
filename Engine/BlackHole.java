package Engine;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.Timer;

public class BlackHole extends Entity {

    private Player player;
    private Image image_clicked;
    private int x_clicked;
    private int y_clicked;


    public BlackHole (int x, int y, int width, int height, Player player) {
        super("img/black_hole.png", x, y, width, height);

        this.player = player;
        this.x_clicked = x - 10;
        this.y_clicked = y - 10;

        image_clicked = image.getScaledInstance(width + 20,  height + 20, Image.SCALE_DEFAULT);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                System.out.printf("Mouse: (%d, %d)\n", mouseX, mouseY);

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    resizeWhenClicked();
                    player.addCurrency(1);
                }
            }
        });
    } 

    public void resizeWhenClicked () {
        this.displayed_image = this.image_clicked;
        this.displayed_x = this.x_clicked;
        this.displayed_y = this.y_clicked;
        repaint();

        ActionListener task = new ActionListener() {
            public void actionPerformed (ActionEvent evt) {
                displayed_image = image;
                displayed_x = x;
                displayed_y = y;
                repaint();
            }
        };

        Timer timer = new Timer(50, task);
        timer.setRepeats(false);
        timer.start();
    }
}