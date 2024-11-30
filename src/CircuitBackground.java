import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Dimension;
import javax.imageio.ImageIO;


public class CircuitBackground extends JPanel {
    private int width;
    private int height;


    public CircuitBackground(int width, int height) {
        super();
        super.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
    }

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
