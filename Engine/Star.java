package Engine;

public class Star extends Entity {

    public Star (int x, int y, int width, int height) throws ImageNotFoundException {
        super("img/star.png", x, y, width, height, 1);
    }
}