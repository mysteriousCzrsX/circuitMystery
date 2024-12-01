import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.Vector;

public class MysteryWindow extends JFrame {
    MenuPanel menu = new MenuPanel();
    GamePanel game = new GamePanel();
    ScorePanel scoreboard = new ScorePanel();
    FinishScreen finish = new FinishScreen();
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    Vector<Long> scores = new Vector<Long>();
    
    JPanel info = new InfoPanel();
    GameStatus state = GameStatus.MENU;
    Timer timer = new Timer(game::updateTimeDisplay);

    
    
    public MysteryWindow(int width, int height) {

        super("Circuit mystery");
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel.add(menu, "menu");
        cardPanel.add(game, "game");
        cardPanel.add(scoreboard, "score");
        cardPanel.add(info, "info");
        cardPanel.add(finish, "finish");
        add(cardPanel, BorderLayout.CENTER);
    }

    private void startGame() {
        cardLayout.show(cardPanel, "game");
        game.initializeGame();
        state = GameStatus.GAME_PLAYING;
        timer.startTimer();
    }

    private void finishGame() {
        long time = timer.stopTimer();
        scores.add(time);
        scoreboard.updateScores(scores);
        finish.writeTime(time);
        cardLayout.show(cardPanel, "finish");
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
                    //do nothing
                    break;
                case GAME_CHECK:
                    game.checkIfSolved();
                    break;
                case GAME_ABORTED:
                    timer.stopTimer();
                    game.cleanUpGame();
                    state = GameStatus.MENU;
                    break;
                case GAME_FINISHED:
                    finishGame();
                    break;
                case SCORE:
                    cardLayout.show(cardPanel, "score");
                    break;
                case INFO:
                    cardLayout.show(cardPanel, "info");
                    break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        }
    }
}
