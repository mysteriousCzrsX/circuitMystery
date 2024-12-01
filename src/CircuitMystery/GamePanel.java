package CircuitMystery;
import javax.swing.*;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.Random;

/**
 * Panel containing the game screen.
 */
public class GamePanel extends JPanel {

    /**
     * Button to end the game.
     */
    JButton endButton = new JButton("End game");
    /**
     * Button to check if current circuit is solved.
     */
    JButton doneButton = new JButton("Done");
    /**
     * Text field displaying the play time.
     */
    JTextField timerArea = new JTextField();
    /**
     * Array of circuits, to be displayed as next levels of the game.
     */
    Circuit [] circuit = new Circuit[4];
    /**
     * Index of the current circuit.
     */
    int currentCircuit = 0;
    
    /**
     * Constructor for the GamePanel class.
     */
    GamePanel() {
        super();
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        add(endButton);
        endButton.addActionListener(e -> {
            MysteryWindow rootWindow  = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            rootWindow.state = GameStatus.GAME_ABORTED;
        });
        add(doneButton);
        doneButton.addActionListener(e -> {
            MysteryWindow rootWindow  = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            rootWindow.state = GameStatus.GAME_CHECK;
        });
        timerArea.setBorder(null);
        timerArea.setOpaque(false);
        timerArea.setBackground(new Color(0, 0, 0, 0));
        timerArea.setFont(new Font("Monospaced", Font.BOLD, 20));
        timerArea.setText("Time: 00:00");
        timerArea.setEditable(false);
        add(timerArea);
    }

    /**
     * Updates the time display value.
     * And wirtes it as minutes and seconds to the timerArea.
     * @param timeNano Time in nanoseconds.
     */
    public void updateTimeDisplay(long timeNano){
        long minutes = timeNano / 60_000_000_000L;
        long seconds = (timeNano / 1_000_000_000) % 60;
        timerArea.setText(String.format("Time: %02d:%02d", minutes, seconds));
    }

    /**
     * Initializes the game. 
     * Creates 4 random circuit types and adds the first one to the panel.
     */
    public void initializeGame(){
        currentCircuit = 0;
        int circuitIndex = 0;
        Random rand = new Random();
        for (int i = 0; i < 4; i++){
            circuitIndex = rand.nextInt(5);
            switch(circuitIndex){
                case 0:
                    circuit[i] = new Circuit1();
                    break;
                case 1:
                    circuit[i] = new Circuit2();
                    break;
                case 2:
                    circuit[i] = new Circuit3();
                    break;
                case 3:
                    circuit[i] = new Circuit4();
                    break;
                case 4:
                    circuit[i] = new Circuit5();
                    break;
            }
        }
        add(circuit[currentCircuit]);
        revalidate();
        repaint();
        circuit[currentCircuit].addCircuitImage();
        circuit[currentCircuit].isSolved();
    }

    /**
     * Checks if the current circuit is solved.
     * If it is, it removes the current circuit and adds the next one.
     * If the last circuit is solved, the game is finished.
     */
    public void checkIfSolved(){
        MysteryWindow rootWindow  = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
        if(circuit[currentCircuit].isSolved()){
            if(currentCircuit == 3){
                rootWindow.state = GameStatus.GAME_FINISHED;
                cleanUpGame();
                return;
            }
            else{
                remove(circuit[currentCircuit]);
                currentCircuit++;
                add(circuit[currentCircuit]);
                revalidate();
                repaint();
                circuit[currentCircuit].addCircuitImage();
                circuit[currentCircuit].isSolved();
            }
        }
        rootWindow.state = GameStatus.GAME_PLAYING;
    }

    /**
     * Cleans up the game. 
     * Removes the current circuit and resets the time display.
     * Called when the game is aborted or finished.
     */
    public void cleanUpGame(){
        remove(circuit[currentCircuit]);
        currentCircuit = 0;
        revalidate();
        repaint();
        updateTimeDisplay(0);
    }
}