package Engine;
public class Main {
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        @SuppressWarnings("unused")
        Game game = new Game(gui);

        gui.addEntity(new BlackHole(50, 50, 100, 100, 2, 100, 1));

        Resource resource = new Resource();
    }
}