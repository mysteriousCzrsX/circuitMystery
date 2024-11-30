import java.util.Collections;
import java.util.Vector;
import javax.swing.*;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;


public class ScorePanel extends JPanel {
    JButton backButton = new JButton("Back");
    JTextField title = new JTextField("High Scores");
    JTextArea scoreArea = new JTextArea();
    ScorePanel() {
        super();

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(boxLayout);

        add(Box.createRigidArea(new Dimension(0,10)));
        title.setMaximumSize(new Dimension(140, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(null);
        title.setOpaque(false);
        title.setFont(new Font("Monospaced", Font.BOLD, 20));
        title.setEditable(false);
        
        add(title);

        add(Box.createRigidArea(new Dimension(0,10)));
        scoreArea.setBorder(null);
        scoreArea.setOpaque(false);
        scoreArea.setMaximumSize(new Dimension(100, 35));
        scoreArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        scoreArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(scoreArea);

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(backButton);
        backButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(ScorePanel.this);
            window.state = GameStatus.MENU;
        });
    }

    public void updateScores(Vector<Long> scores){
        Vector<Long> scoresCopy = new Vector<Long>(scores);
        Collections.sort(scoresCopy);
        scoreArea.setText("");
        int length = scores.size() * 33;
        for (int i = 0; i < scores.size(); i++){
            scoreArea.append(String.format("%d. %02d:%02d\n", i + 1, scoresCopy.get(i) / 60_000_000_000L, (scoresCopy.get(i) / 1_000_000_000) % 60));
        }
        scoreArea.setMaximumSize(new Dimension(100, length));
        revalidate();
        repaint();

    }
    
}
