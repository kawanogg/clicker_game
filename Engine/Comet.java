package Engine;

public class Comet extends Entity {

    public Comet (int x, int y, int width, int height) throws ImageNotFoundException {
        super("img/comet.png", x, y, width, height, 2);
    }
}