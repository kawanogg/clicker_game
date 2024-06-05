package Engine;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class BlackHole extends Entity {

    Player player;
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                System.out.printf("Mouse: (%d, %d)\n", mouseX, mouseY);

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    resizeWhenClicked();
                    Timer timer = new Timer(50, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            resizeBack();
                            repaint();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                    player.addCurrency(1);
                }
            }
        });

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
}