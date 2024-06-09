package Engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GUI {
    private Panel panel;
    private Frame frame;

    public GUI () throws IOException, ClassNotFoundException {
        Player p = definePlayer();
        p.initializeComponents();
        this.frame = new Frame();
        this.panel = new Panel(p);
    }

    private Player definePlayer() throws IOException, ClassNotFoundException {
        File file = new File("game-state.txt");

        if(file.exists()){
            FileInputStream fileIn = new FileInputStream("game-state.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Player p = (Player) objectIn.readObject();

            objectIn.close();
            fileIn.close();

            return p;
        }

        return new Player();
    }

    public void openFrame () throws IOException {
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
}