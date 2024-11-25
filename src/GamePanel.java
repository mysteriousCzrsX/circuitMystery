import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Font;

public class GamePanel extends JPanel {
    JButton endButton = new JButton("End game");
    JButton doneButton = new JButton("Done");
    JTextArea timerArea = new JTextArea();
    GamePanel() {
        super();
        add(endButton);
        endButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            window.state = GameStatus.MENU;
        });
        add(doneButton);
        doneButton.addActionListener(e -> {
            //MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            //window.state = GameStatus.SCORE;
        });
        timerArea.setFont(new Font("Monospaced", Font.BOLD, 10));
        add(timerArea);
    }
}