import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Dimension;
import java.awt.FlowLayout;

abstract class Ciurcuit extends JPanel {
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

    public Ciurcuit() {
        super();
        super.setPreferredSize(new Dimension(width, height));
        super.setLayout(new FlowLayout());
    }

    public void setBackground(){
        BufferedImage background = null;
        try{
            background = ImageIO.read(new File(backgroundPath));
        } 
        catch (Exception e){
            System.out.println("Circuit image not found");
        }
        Graphics g = getGraphics();
        g.drawImage(background, 0, 0, width, height - 100, this);
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
                resistorTexts[i] = new ValueText("???", true);
            }
            else{
                resistorTexts[i] = new ValueText(String.valueOf(resistorValues[i]), false);
            }
            add(resistorTexts[i]);
        }
        for (int i = 0; i < noVoltageSources; i++){
            voltageSourceTexts[i] = new ValueText(String.valueOf(voltageSourceValues[i]), false);
            add(voltageSourceTexts[i]);
        }
    }

    public abstract boolean isSolved();
}
