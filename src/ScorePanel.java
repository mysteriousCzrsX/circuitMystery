import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;


public class ScorePanel extends JPanel {
    JButton backButton = new JButton("Back");
    JTable scoreArea = new JTable();
    ScorePanel(Vector<Long> scores) {
        super();
        add(backButton);
        backButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(ScorePanel.this);
            window.state = GameStatus.MENU;
        });

        add(scoreArea);
    }
    
}
