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
    JPanel scoreboard = new ScorePanel();
    
    
    public MysteryWindow(int width, int height) {

        super("Circuit mystery");
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel.add(menu, "menu");
        cardPanel.add(game, "game");
        add(cardPanel, BorderLayout.CENTER);
    }

    public void startGame() {
        cardLayout.show(cardPanel, "game");
    }

    public void spin(){

    }
}
