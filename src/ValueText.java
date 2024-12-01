import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;

public class ValueText extends JPanel{
    private JTextField descriptorField = new JTextField();
    private JTextField valueField = new JTextField();
    public ValueText(String descriptor, String index, String value, Boolean editable){
        super();
        setLayout(new FlowLayout());
        descriptorField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        valueField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        descriptorField.setHorizontalAlignment(JTextField.CENTER);
        valueField.setHorizontalAlignment(JTextField.CENTER);

        String descriptorText = String.format("%s%s:", descriptor, index);
        descriptorField.setText(descriptorText);
        descriptorField.setEditable(false);
        descriptorField.setBorder(null);
        descriptorField.setOpaque(false);
        descriptorField.setBackground(new Color(0, 0, 0, 0));
        add(descriptorField);

        valueField.setText(value);
        valueField.setEditable(editable);
        add(valueField);

    }

    public double getValue(){
        String userText = valueField.getText();
        if(userText.matches("-?\\d+(\\.\\d+)?")){
            return Double.parseDouble(userText);
        }
        else{
            return 0.0;
        }
    }
}
