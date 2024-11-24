import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel {
    JButton endButton = new JButton("End game");
    GamePanel() {
        super();
        add(endButton);
        endButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(GamePanel.this);
            window.state = GameStatus.MENU;
        });
    }
}