public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Game game = new Game(gui);

        gui.addEntity(new Planet(50, 50, 100, 100));
    }
}