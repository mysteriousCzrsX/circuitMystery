import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

abstract class Circuit extends JPanel {
    protected String backgroundPath;
   
    private int width = 600;
    private int height = 500;
    protected CircuitBackground circuitBackground = new CircuitBackground(width, height - 50);

    protected double [] resistorValues;
    protected int noResistors;
    protected ValueText [] resistorTexts;
    protected int missingResistorIndex;

    protected double [] voltageSourceValues;
    protected ValueText [] voltageSourceTexts;
    protected int noVoltageSources;

    public Circuit() {
        super();
        super.setPreferredSize(new Dimension(width, height));
        super.setLayout(new FlowLayout());
    }

    public void addCircuitImage(){
        add(circuitBackground);
        circuitBackground.set(backgroundPath);
    }

    protected void randomizeComponentValues(){
        int randomValue = 0;
        for (int i = 0; i < noResistors; i++){
            do{
                randomValue = (int) (Math.random() * 1000);    
            }while(randomValue == 0);
            resistorValues[i] = randomValue;
        }
        for (int i = 0; i < noVoltageSources; i++){
            do{
                randomValue = (int) (Math.random() * 20);    
            }while(randomValue == 0);
            voltageSourceValues[i] = randomValue;
        }
    }

    protected void setupTextFields(){
        resistorTexts = new ValueText[noResistors];
        voltageSourceTexts = new ValueText[noVoltageSources];
        for (int i = 0; i < noResistors; i++){
            if (i == missingResistorIndex){
                resistorTexts[i] = new ValueText("R", i, "???", true);
            }
            else{
                resistorTexts[i] = new ValueText("R", i, String.valueOf(resistorValues[i]), false);
            }
            add(resistorTexts[i]);
        }
        for (int i = 0; i < noVoltageSources; i++){
            voltageSourceTexts[i] = new ValueText("E", i, String.valueOf(voltageSourceValues[i]), false);
            add(voltageSourceTexts[i]);
        }
    }

    public abstract boolean isSolved();
}
