/**
 * Circuit2 class is a subclass of Circuit that represents the simple
 * voltage divider with one resistor changed for two parellel ones.
 */
public class Circuit2 extends Circuit {
    /**
     * Constructor for the Circuit2 class
     * it sets the correct background image and the number of resistors and voltage sources
     * and calls the randomizeComponentValues and setupTextFields methods
     */
    public Circuit2() {
        super();
        backgroundPath = "assets/circuit2.png";
        noResistors = 3;
        noVoltageSources = 1;
        resistorValues = new double[noResistors];
        voltageSourceValues = new double[noVoltageSources];
        resistorVoltages = new int[noResistors];
        missingResistorVoltageIndex = 2;

        randomizeComponentValues();
        setupTextFields();
    }

    /**
     * isSolved method checks if the user input is correct
     * implementation of an abstract method from the Circuit class
     */
    @Override
    public boolean isSolved() {
        double R0_R1_parallel = (resistorValues[0] * resistorValues[1]) / (resistorValues[0] + resistorValues[1]);
        double result = (voltageSourceValues[0] * resistorValues[2]) / (R0_R1_parallel + resistorValues[2]);
        result = Math.round(result * 100.0) / 100.0;
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        System.out.println("Result: " + result + " User input: " + userInput);
        return result == userInput;
    } 
}