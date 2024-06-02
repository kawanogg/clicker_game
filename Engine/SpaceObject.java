package Engine;

import java.awt.Image;

public class SpaceObject extends Entity {
    public SpaceObject (String imagePath, int x, int y, int width, int height) {
        super(imagePath, x, y, width, height);
    }

    public Image getImage () {
        return this.image;
    }
}