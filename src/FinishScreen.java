import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class FinishScreen extends JPanel{
    private JButton backButton = new JButton("Back");
    private JTextField title = new JTextField("Congratulations you finished the game!");
    private JTextField score = new JTextField();

    public FinishScreen(){
        super();
        
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(boxLayout);

        add(Box.createRigidArea(new Dimension(0,200)));
        title.setMaximumSize(new Dimension(460, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(null);
        title.setOpaque(false);
        title.setFont(new Font("Monospaced", Font.BOLD, 20));
        title.setEditable(false);
        add(title);

        add(Box.createRigidArea(new Dimension(0,10)));
        score.setMaximumSize(new Dimension(200, 35));
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setFont(new Font("Monospaced", Font.PLAIN, 20));
        score.setOpaque(false);
        score.setBorder(null);
        add(score);

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(backButton);
        backButton.addActionListener(e -> {
            MysteryWindow window = (MysteryWindow) SwingUtilities.getWindowAncestor(FinishScreen.this);
            window.state = GameStatus.MENU;
        });
    }

    public void writeTime(long time){
        long minutes = time / 60_000_000_000L;
        long seconds = (time / 1_000_000_000) % 60;
        score.setText(String.format("Your time: %02d:%02d", minutes, seconds));
    }
    
}
