import javax.swing.JTextField;
import java.awt.Font;

public class ValueText extends JTextField{
    public ValueText(String value, Boolean editable){
        super();
        super.setFont(new Font("Monospaced", Font.PLAIN, 12));
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setText(value);
        super.setEditable(editable);
    }

    public void move(int x, int y){
        int width = getPreferredSize().width;
        int height = getPreferredSize().height;
        super.setBounds(x, y, width, height);
    }
}
