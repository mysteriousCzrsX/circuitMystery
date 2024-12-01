
public class Circuit4 extends Circuit {
    public Circuit4() {
        super();
        backgroundPath = "assets/circuit4.png";
        noResistors = 2;
        noVoltageSources = 1;
        resistorValues = new double[noResistors];
        voltageSourceValues = new double[noVoltageSources];
        resistorVoltages = new int[noResistors];
        missingResistorVoltageIndex = 1;

        randomizeComponentValues();
        setupTextFields();
    }

    @Override
    public boolean isSolved() {
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        return voltageSourceValues[0] == userInput;
    } 
}
