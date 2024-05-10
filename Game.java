

public class Game {
    // Atributos
    private Window window;

    // Métodos
    public Game () {
        this.window = new Window(640, 320, "Algum Clicker");
    }

    public void startGame () {
        window.setVisible(true);
    }
}