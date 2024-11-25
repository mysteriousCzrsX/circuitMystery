import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.Vector;

public class MysteryWindow extends JFrame {
    MenuPanel menu = new MenuPanel();
    GamePanel game = new GamePanel();
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    Vector<Integer> scores = new Vector<Integer>();
    JPanel scoreboard = new ScorePanel(scores);
    JPanel info = new InfoPanel();
    GameStatus state = GameStatus.MENU;
    
    
    public MysteryWindow(int width, int height) {

        super("Circuit mystery");
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel.add(menu, "menu");
        cardPanel.add(game, "game");
        cardPanel.add(scoreboard, "score");
        cardPanel.add(info, "info");
        add(cardPanel, BorderLayout.CENTER);
    }

    public void startGame() {
        cardLayout.show(cardPanel, "game");
        state = GameStatus.GAME_PLAYING;
    }

    public void spin(){
        while (true) {
            switch (state) {
                case MENU:
                    cardLayout.show(cardPanel, "menu");
                    break;
                case GAME_START:
                    startGame();
                    break;
                case GAME_PLAYING:
                    // measure time and idk xd
                    break;
                case GAME_CHECK:
                    //check if solved correctly and if game finished
                    break;
                case GAME_FINISHED:
                    //show score
                    break;
                case SCORE:
                    cardLayout.show(cardPanel, "score");
                    break;
                case INFO:
                    cardLayout.show(cardPanel, "info");
                    break;
            }
        }
    }
}
