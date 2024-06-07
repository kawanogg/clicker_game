package Engine;

public class GUI {
    private Panel panel;
    private Frame frame;


    public GUI () {
        this.frame = new Frame();
        this.panel = new Panel(new Player());
    }

    public void openFrame () {
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
}