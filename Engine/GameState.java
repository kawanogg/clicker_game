package Engine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;

public class GameState {
    private Player player;
    private FileOutputStream fileOut;
    private ObjectOutputStream objOut;
    private int x, y;
    private JButton saveButton;

    public GameState(int x, int y, Player player) throws IOException {
        this.x = x;
        this.y = y;
        this.player = player;

        this.saveButton = new JButton("Save");
        this.saveButton.setBounds(this.x, this.y, 100, 30);
    }

    public void saveGame() throws IOException {
        this.fileOut = new FileOutputStream("game-state.txt");
        this.objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(this.player);
        objOut.close();
        fileOut.close();
    }

    public JButton getButton() {
        return saveButton;
    }
}
