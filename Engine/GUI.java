package Engine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GUI {
    private Panel panel;
    private Frame frame;
    //private GameState gameState;

    FileInputStream fileIn = new FileInputStream("game-state.txt");
    ObjectInputStream objectIn = new ObjectInputStream(fileIn);


    public GUI () throws IOException, ClassNotFoundException {
        Player p = (Player) objectIn.readObject();
        p.initializeComponents();
        this.frame = new Frame();
        this.panel = new Panel(p);
         
        System.out.println("cheguei aqui");
        //this.gameState = new GameState(p);

        objectIn.close();
        fileIn.close();
    }

    public void openFrame () throws IOException {
        this.frame.add(this.panel);
        this.frame.setVisible(true);

        // ActionListener task = new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         try {
        //             gameState.saveGame();
        //         } catch (IOException ex) {
        //             throw new RuntimeException(ex);
        //         }
        //     }
        // };

        // Timer timer = new Timer(10000, task);
        // timer.setRepeats(false);
        // timer.start();
    }
}