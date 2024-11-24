import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    JButton endButton = new JButton("End game");
    GamePanel() {
        super();
        add(endButton);
    }
}