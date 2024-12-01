import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Dimension;
import javax.imageio.ImageIO;

/**
 * CircuitBackground class that sets the background of the circuit
 * 
 * @param width - the width of the background
 * @param height - the height of the background
 */

public class CircuitBackground extends JPanel {
    private int width;
    private int height;

    /**
     * Constructor for the CircuitBackground class
     * 
     * @param width - the width of the background
     * @param height - the height of the background
     */
    public CircuitBackground(int width, int height) {
        super();
        super.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
    }
    /**
     * set - paint the background image to be displayed
     * This method is necesary because you can't call the paintComponent
     * method if the object is not yet visible.
     * 
     * @param backgroundPath - the path to the background image
     */
    public void set(String backgroundPath){
        BufferedImage background = null;
        try{
            background = ImageIO.read(new File(backgroundPath));
        } 
        catch (Exception e){
            System.out.println("Circuit image not found");
        }
        Graphics g = getGraphics();
        g.drawImage(background, 0, 0, width, height, this);
    }
    
}
