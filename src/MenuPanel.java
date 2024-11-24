import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    JButton startButton = new JButton("Start game");
    JButton scoreButton = new JButton("Scoreboard");
    JButton infoButton = new JButton("Game info");
    JButton QuitButton = new JButton("Quit game");
    MenuPanel() {
        super();
        add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(MenuPanel.this);
                window.startGame();
            }
        });
        add(scoreButton);
        add(infoButton);
        add(QuitButton);
        QuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
}
