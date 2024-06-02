package Engine;

public class Game {
    
    @SuppressWarnings("unused")
    private GUI gui;

    public Game () {
        this.gui = new GUI();
    }

    public void startGame () {
        this.gui.openFrame();
    }
}