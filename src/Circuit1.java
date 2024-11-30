
public class Circuit1 extends Circuit {
    public Circuit1() {
        super();
        backgroundPath = "assets/circuit1.png";
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
        double result = (voltageSourceValues[0] * resistorValues[missingResistorVoltageIndex]) / (resistorValues[0] + resistorValues[1]);
        result = Math.round(result * 10.0) / 10.0;
        double userInput = Double.parseDouble(resistorVoltageTexts[missingResistorVoltageIndex].getText());
        System.out.println("Result: " + result + " User input: " + userInput + '\n');
        return result == userInput;
    } 
}
