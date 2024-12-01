package CircuitMystery;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * Panel containing the game menu.
 * It handles switching between diffrent elements of the game
 * using callbacks assigned to the buttons.
 */
public class MenuPanel extends JPanel {
    private JButton startButton = new JButton("Start game");
    private JButton scoreButton = new JButton("Scoreboard");
    private JButton infoButton = new JButton("Game info");
    private JButton quitButton = new JButton("Quit game");
    
    /**
     * Constructor for the MenuPanel class.
     */
    MenuPanel() {
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(boxLayout);
        add(Box.createRigidArea(new Dimension(0,100)));
        
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(MenuPanel.this);
                window.state = GameStatus.GAME_START;
            }
        });
        add(Box.createRigidArea(new Dimension(0,10)));
        
        scoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(scoreButton);
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(MenuPanel.this);
                window.state = GameStatus.SCORE;
            }
        });
        add(Box.createRigidArea(new Dimension(0,10)));

        infoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(MenuPanel.this);
                window.state = GameStatus.INFO;
            }
        });
        add(Box.createRigidArea(new Dimension(0,10)));

        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
}
