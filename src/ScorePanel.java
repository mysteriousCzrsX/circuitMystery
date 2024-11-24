import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ScorePanel extends JPanel {
    JButton backButton = new JButton("Back");
    JTextArea scoreArea = new JTextArea();
    ScorePanel(Vector<Integer> scores) {
        super();
        add(backButton);
        
        add(scoreArea);
    }
    
}
