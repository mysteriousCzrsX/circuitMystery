package CircuitMystery;
/**
 * Circuit1 class is a subclass of Circuit that represents the simple
 * voltage divider circuit.
 */
public class Circuit1 extends Circuit {
    /**
     * Constructor for the Circuit1 class
     * it sets the correct background image and the number of resistors and voltage sources
     * and calls the randomizeComponentValues and setupTextFields methods
     */
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

    /**
     * isSolved method checks if the user input is correct
     * implementation of an abstract method from the Circuit class
     */
    @Override
    public boolean isSolved() {
        double result = (voltageSourceValues[0] * resistorValues[missingResistorVoltageIndex]) / (resistorValues[0] + resistorValues[1]);
        result = Math.round(result * 100.0) / 100.0;
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        return result == userInput;
    } 
}
