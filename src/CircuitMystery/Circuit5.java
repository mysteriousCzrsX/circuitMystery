package CircuitMystery;
/**
 * Circuit5 class is a subclass of Circuit that represents five resistors in series.
 */
public class Circuit5 extends Circuit {
    /**
     * Constructor for the Circuit5 class
     * it sets the correct background image and the number of resistors and voltage sources
     * and calls the randomizeComponentValues and setupTextFields methods
     */
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
    
    /**
     * isSolved method checks if the user input is correct
     * implementation of an abstract method from the Circuit class
     */
    @Override
    public boolean isSolved() {
        double result = (voltageSourceValues[0] * resistorValues[0]) / (resistorValues[1] + resistorValues[2] + resistorValues[0]);
        result = Math.round(result * 100.0) / 100.0;
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        return result == userInput;
    } 
}
