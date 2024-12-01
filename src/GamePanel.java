import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.Random;

import javax.swing.JTextField;

public class GamePanel extends JPanel {
    JButton endButton = new JButton("End game");
    JButton doneButton = new JButton("Done");
    JTextField timerArea = new JTextField();
    Circuit [] circuit = new Circuit[5];
    int currentCircuit = 0;
    
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
    public void updateTimeDisplay(long timeNano){
        long minutes = timeNano / 60_000_000_000L;
        long seconds = (timeNano / 1_000_000_000) % 60;
        timerArea.setText(String.format("Time: %02d:%02d", minutes, seconds));
    }

    public void initializeGame(){
        currentCircuit = 0;
        int circuitIndex = 0;
        Random rand = new Random();
        for (int i = 0; i < 5; i++){
            circuitIndex = rand.nextInt(5);
            //TODO implement other circuits
            switch(circuitIndex){
                case 0:
                    circuit[i] = new Circuit3();
                    break;
                case 1:
                    circuit[i] = new Circuit3();
                    break;
                case 2:
                    circuit[i] = new Circuit3();
                    break;
                case 3:
                    circuit[i] = new Circuit3();
                    break;
                case 4:
                    circuit[i] = new Circuit3();
                    break;
            }
        }
        add(circuit[currentCircuit]);
        revalidate();
        repaint();
        circuit[currentCircuit].addCircuitImage();
    }

    public void checkIfSolved(){
        MysteryWindow rootWindow  = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
        if(circuit[currentCircuit].isSolved()){
            currentCircuit++;
            System.out.println("Circuit solved\n");
            if(currentCircuit == 4){
                System.out.println("Game finished\n");
                rootWindow.state = GameStatus.GAME_FINISHED;
                cleanUpGame();
                return;
            }
            else{
                remove(circuit[currentCircuit-1]);
                System.out.println("Next circuit\n");
                add(circuit[currentCircuit]);
                revalidate();
                repaint();
                circuit[currentCircuit].addCircuitImage();
            }
        }
        rootWindow.state = GameStatus.GAME_PLAYING;
    }

    public void cleanUpGame(){
        remove(circuit[currentCircuit]);
        currentCircuit = 0;
        revalidate();
        repaint();
        updateTimeDisplay(0);
    }
}