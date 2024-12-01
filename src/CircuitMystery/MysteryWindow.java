package CircuitMystery;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.Vector;


/**
 * Main window of the game. It various game panels organized in a CardLayout.
 */

public class MysteryWindow extends JFrame {

    /**
     * Panel containing the game menu.
     */
    MenuPanel menu = new MenuPanel();
    /**
     * Panel containing the game.
     */
    GamePanel game = new GamePanel();
    /**
     * Panel containing the scoreboard.
     */
    ScorePanel scoreboard = new ScorePanel();
    /**
     * Panel containing the game info.
     */
    InfoPanel info = new InfoPanel();
    /**
     * Panel containing the game finish screen.
     */
    FinishScreen finish = new FinishScreen();
    /**
     * CardLayout for the panels.
     */
    CardLayout cardLayout = new CardLayout();
    /**
     * Panel containing the cards.
     */
    JPanel cardPanel = new JPanel(cardLayout);
    /**
     * Vector containing the scores of the players.
     */
    Vector<Long> scores = new Vector<Long>();
    /**
     * Enum containing the different states of the game.
     */
    GameStatus state = GameStatus.MENU;
    /**
     * Timer object for the game.
     */
    Timer timer = new Timer(game::updateTimeDisplay);

    
    /**
     * Constructor for the MysteryWindow class.
     * @param width Window width
     * @param height Window height
     */
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

    /**
     * Starts the game. Changes state variable, 
     * starts timer and calls initializeGame method from GamePanel.
     */
    
    private void startGame() {
        cardLayout.show(cardPanel, "game");
        game.initializeGame();
        state = GameStatus.GAME_PLAYING;
        timer.startTimer();
    }

    /**
     * Finishes the game. Changes state variable, 
     * stops timer. Updateds time in scorebaord
     * and shows the finish screen.
     */

    private void finishGame() {
        long time = timer.stopTimer();
        scores.add(time);
        scoreboard.updateScores(scores);
        finish.writeTime(time);
        cardLayout.show(cardPanel, "finish");
        state = GameStatus.GAME_PLAYING;
    }

    /**
     * Main loop of the game. 
     * It switches between different states of the game.
     * It calls various functions depending on the state.
     */

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
                    //game logic is handled in callbacks so we do nothing here
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
            //This sllep ensures stability of the program.
            //Without it this loop runs to fast resulting in race conditions.
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        }
    }
}