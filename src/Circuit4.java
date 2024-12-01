/**
 * Circuit4 class is a subclass of Circuit that represents two resistors in parallel
 */
public class Circuit4 extends Circuit {
    /**
     * Constructor for the Circuit4 class
     * it sets the correct background image and the number of resistors and voltage sources
     * and calls the randomizeComponentValues and setupTextFields methods
     */
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
    
    /**
     * isSolved method checks if the user input is correct
     * implementation of an abstract method from the Circuit class
     */
    @Override
    public boolean isSolved() {
        double userInput = resistorVoltageTexts[missingResistorVoltageIndex].getValue();
        return voltageSourceValues[0] == userInput;
    } 
}
