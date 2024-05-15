import java.util.ArrayList;

public class Game {

    // Atributos
    private Window window;
    private ArrayList<Entity> Entidades = new ArrayList<>();

    // Métodos
    public Game () {
        this.window = new Window(640, 320, "Algum Clicker");

    }

    public void startGame () {
        window.setVisible(true);
    }
}