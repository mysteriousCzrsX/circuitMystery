import javax.swing.JTextField;

public class Circuit1 extends Ciurcuit {
    JTextField value1 = new JTextField();
    public Circuit1() {
        super();
        backgroundPath = "assets/circuit1.png";
        noResistors = 2;
        noVoltageSources = 1;
        resistorValues = new double[noResistors];
        voltageSourceValues = new double[noVoltageSources];
        missingResistorIndex = 1;
        randomizeComponentValues();
        setupTextFields();
        //addTextFields();
    }

    private void addTextFields(){
        voltageSourceTexts[0].move(10, 50);
        add(voltageSourceTexts[0]);
    }

    @Override
    public boolean isSolved() {
        double result = (voltageSourceValues[0] * resistorValues[0]) / (resistorValues[0] + resistorValues[1]);
        double userInput = Double.parseDouble(resistorTexts[missingResistorIndex].getText());
        return result == userInput;
    }

    @Override
    protected void randomizeComponentValues() {

    }
    
}
