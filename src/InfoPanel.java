import javax.swing.*;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;

public class InfoPanel extends JPanel {
    JButton backButton = new JButton("Back");
    JTextArea infoArea = new JTextArea();
    InfoPanel() {
        super();

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(boxLayout);

        add(Box.createRigidArea(new Dimension(0,50)));
        infoArea.setMaximumSize(new Dimension(600, 300));
        infoArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setBorder(null);
        infoArea.setOpaque(false);
        infoArea.setText(
            "CircuitMystert is a game where you have to solve electrical circuits as a puzzle. "+
            "Upon starting the game, you will be presented with a circuit. You have to correctly fill in missing values "+
            "If you are succesful the game will present you with a new circuit. After solving five circuit the game will end and you will see your score "+
            "This game was made for object oriented programming course at Gdansk University of Technology\n"+
            "Author: Cezary Wieczorkowski"

        );
        add(infoArea);
        
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(backButton);
        backButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(InfoPanel.this);
            window.state = GameStatus.MENU;
        });
    }
    
}
