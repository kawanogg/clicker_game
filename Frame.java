import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        setTitle("Entidade com Imagem");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Entity entityPanel = new Entity("images.jpeg");

        this.add(entityPanel); //Frame adiciona Panel (imagem).
        
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();


        frame.setVisible(true);
    }
}