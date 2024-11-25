import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Font;

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
        infoArea.setFont(new Font("Monospaced", Font.PLAIN, 10));
        infoArea.setText(
            "CircuitMystert is a game where you have to solve electrical circuits as a puzzle.\n"+
            "Upon starting the game, you will be presented with a circuit. You have to correctly fill in missing values\n"+
            "If you are succesful the game will present you with a new circuit. After solving five circuit the game will end and you will see your score\n\n"+
            "This game was made for object oriented programming course at Gdansk University of Technology\n"+
            "Author: Cezary Wieczorkowski"

        );
        add(infoArea);
    }
    
}
