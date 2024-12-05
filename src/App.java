import CircuitMystery.MysteryWindow;
/**
 * Main app class that creates game window and starts the game loop.
 */

public class App {
    public static void main(String[] args) throws Exception {
        MysteryWindow window = new MysteryWindow(800, 600);
        window.setVisible(true);
        window.spin();
    }
}

