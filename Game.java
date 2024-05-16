import java.util.ArrayList;

public class Game {
    private Frame frame;
    private ArrayList<Entity> entities;

    public Game () {
        this.frame = new Frame();
        this.entities = new ArrayList<Entity>();

        this.frame.setVisible(true);
    }

    public void addEntity(Entity newEntity) {
        this.entities.add(newEntity);
        this.frame.add(newEntity);

        this.frame.setVisible(true);
    }
}