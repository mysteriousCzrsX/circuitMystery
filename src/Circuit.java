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

    protected int [] resistorVoltages;
    protected int missingResistorVoltageIndex;
    protected ValueText [] resistorVoltageTexts;

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

    public abstract boolean isSolved();

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
                resistorVoltageTexts[i] = new ValueText("V", String.format(suffix, i), "???", true);
                add(resistorVoltageTexts[i]);
            }
        }





        
    }

    
}
