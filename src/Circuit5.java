
public class Circuit5 extends Circuit {
    public Circuit5() {
        super();
        backgroundPath = "assets/circuit5.png";
        noResistors = 3;
        noVoltageSources = 1;
        resistorValues = new double[noResistors];
        voltageSourceValues = new double[noVoltageSources];
        resistorVoltages = new int[noResistors];
        missingResistorVoltageIndex = 0;

        randomizeComponentValues();
        setupTextFields();
    }

    @Override
    public boolean isSolved() {
        double result = (voltageSourceValues[0] * resistorValues[0]) / (resistorValues[1] + resistorValues[2] + resistorValues[0]);
        result = Math.round(result * 100.0) / 100.0;
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        System.out.println("Result: " + result + " User input: " + userInput);
        return result == userInput;
    } 
}
