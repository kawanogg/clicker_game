package Engine;

import java.io.IOException;

public class Game {
    
    @SuppressWarnings("unused")
    private GUI gui;

    public Game () throws IOException, ClassNotFoundException {
        this.gui = new GUI();
    }

    public void startGame () throws IOException {
        this.gui.openFrame();
    }
}