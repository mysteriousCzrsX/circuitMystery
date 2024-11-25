import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel {
    JButton endButton = new JButton("End game");
    JButton doneButton = new JButton("Done");
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
    }
}