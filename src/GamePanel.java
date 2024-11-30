import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JTextField;

public class GamePanel extends JPanel {
    JButton endButton = new JButton("End game");
    JButton doneButton = new JButton("Done");
    JTextField timerArea = new JTextField();
    Circuit1 circuit1 = new Circuit1();
    
    GamePanel() {
        super();
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        add(endButton);
        endButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            window.state = GameStatus.GAME_ABORTED;
        });
        add(doneButton);
        doneButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            window.state = GameStatus.GAME_CHECK;
        });
        timerArea.setBorder(null);
        timerArea.setOpaque(false);
        timerArea.setBackground(new Color(0, 0, 0, 0));
        timerArea.setFont(new Font("Monospaced", Font.BOLD, 20));
        timerArea.setText("Time: 00:00");
        timerArea.setEditable(false);
        add(timerArea);
        add(circuit1);
    }
    public void updateTimeDisplay(long timeNano){
        long minutes = timeNano / 60_000_000_000L;
        long seconds = (timeNano / 1_000_000_000) % 60;
        timerArea.setText(String.format("Time: %02d:%02d", minutes, seconds));
    }
}