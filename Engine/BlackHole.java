package Engine;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BlackHole extends Entity {

    Player player;

    public BlackHole (int x, int y, int width, int height, Player player) {
        super("img/black_hole.png", x, y, width, height);

        this.player = player;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                System.out.printf("Mouse: (%d, %d)\n", mouseX, mouseY);

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    player.addCurrency(1);
                }
            }
        });
    } 
}