import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Planet extends Entity {
    private int currentCurrency;

    public Planet (int x, int y, int width, int height) {
        super("img/planet.png", x, y, width, height);
        currentCurrency = 0;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                System.out.printf("Mouse: (%d, %d)\n", mouseX, mouseY);

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    currentCurrency++;
                    System.out.println("+1");
                }
            }
        });
    }

    
}