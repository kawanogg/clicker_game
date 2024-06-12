package Engine;

public class Planet extends Entity {

    public Planet (int x, int y, int width, int height) throws ImageNotFoundException {
        super("img/planet.png", x, y, width, height, 0);
    }
}