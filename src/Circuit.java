import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * Circuit class describes basic properties of a circuit
 * all of the circuit types inherit from this class
 * 
 */
abstract class Circuit extends JPanel {
    /**
     * backgroundPath - the path to the background image
     */
    protected String backgroundPath;
   /**
     * width - the width of the circuit
     */
    private int width = 600;
    /**
     * height - the height of the circuit
     */
    private int height = 500;
    /**
     * circuitBackground - the background of the circuit
     */
    protected CircuitBackground circuitBackground = new CircuitBackground(width, height - 50);
    /**
     * resistorValues - the values of the resistors
     */
    protected double [] resistorValues;
    /**
     * noResistors - the number of resistors in the circuit
     */
    protected int noResistors;
    /**
     * resistorTexts - the text fields for the resistor descriptions
     */
    protected ValueText [] resistorTexts;

    /**
     * resistorVoltages - the voltages of the resistors
     */
    protected int [] resistorVoltages;
    /**
     * missingResistorVoltageIndex - the index of the resistor voltage that is missing
     */
    protected int missingResistorVoltageIndex;
    /**
     * resistorVoltageTexts - the text fields for the resistor voltages descriptions
     */
    protected ValueText [] resistorVoltageTexts;

    /**
     * voltageSourceValues - the values of the voltage sources
     */
    protected double [] voltageSourceValues;
    /**
     * voltageSourceTexts - the text fields for the voltage source descriptions
     */
    protected ValueText [] voltageSourceTexts;
    /**
     * noVoltageSources - the number of voltage sources in the circuit
     */
    protected int noVoltageSources;

    /**
     * Constructor for the Circuit class
     */
    public Circuit() {
        super();
        super.setPreferredSize(new Dimension(width, height));
        super.setLayout(new FlowLayout());
    }
    /**
     * addCircuitImage - adds the circuit background image to the panel
     * and calls the set method of the CircuitBackground class
     * This method has to be called only after the object is visible
     */
    public void addCircuitImage(){
        add(circuitBackground);
        circuitBackground.set(backgroundPath);
    }

    /**
     * isSolved - checks if the circuit is solved
     * 
     * @return boolean - true if the circuit is solved, false otherwise
     */
    public abstract boolean isSolved();

    /**
     * randomizeComponentValues - randomizes the values of the components
     */
    protected void randomizeComponentValues(){
        int randomValue = 0;
        for (int i = 0; i < noResistors; i++){
            do{
                randomValue = (int) (Math.random() * 1000);    
            }while(randomValue == 0);
            resistorValues[i] = (randomValue / 10) * 10;
        }
        for (int i = 0; i < noVoltageSources; i++){
            do{
                randomValue = (int) (Math.random() * 20);    
            }while(randomValue == 0);
            voltageSourceValues[i] = randomValue;
        }
    }

    /**
     * setupTextFields - fills in text in all ValueText objects,
     * marks missing values as editable, and adds them to the panel
     */
    protected void setupTextFields(){
        resistorTexts = new ValueText[noResistors];
        voltageSourceTexts = new ValueText[noVoltageSources];
        resistorVoltageTexts = new ValueText[noResistors];

        for (int i = 0; i < noVoltageSources; i++){
            voltageSourceTexts[i] = new ValueText("E", String.valueOf(i), String.valueOf(voltageSourceValues[i]), false);
            add(voltageSourceTexts[i]);
        }

        for (int i = 0; i < noResistors; i++){
            resistorTexts[i] = new ValueText("R", String.valueOf(i), String.valueOf(resistorValues[i]), false);
            add(resistorTexts[i]);
        }

        String suffix = "_R%d"; 
        for(int i = 0; i < noResistors; i++){
            if(i == missingResistorVoltageIndex){
                resistorVoltageTexts[i] = new ValueText("V", String.format(suffix, i), "?????", true);
                add(resistorVoltageTexts[i]);
            }
        }   
    }  
}
