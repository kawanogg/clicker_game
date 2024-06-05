package Engine;
public class Main {

    public static void main(String[] args) {
        
        Player player = new Player();
        GUI gui = new GUI(player);
        @SuppressWarnings("unused")
        Game game = new Game(gui);



        gui.addEntity(new BlackHole(50, 50, 100, 100, player));
    }
}