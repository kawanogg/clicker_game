import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BlackHole extends Entity {

    public BlackHole (int x, int y, int width, int height) {
        super("img/black_hole.png", x, y, width, height);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                System.out.printf("Mouse: (%d, %d)\n", mouseX, mouseY);

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    System.out.println("+1");
                }
            }
        });
    } 
}