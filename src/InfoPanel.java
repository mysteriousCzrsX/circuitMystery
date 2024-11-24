import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class InfoPanel extends JPanel {
    JButton backButton = new JButton("Back");
    JTextArea infoArea = new JTextArea();
    InfoPanel() {
        super();
        add(backButton);
        backButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(InfoPanel.this);
            window.state = GameStatus.MENU;
        });
        
        add(infoArea);
    }
    
}
