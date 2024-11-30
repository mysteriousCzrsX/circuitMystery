import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Dimension;

abstract class Ciurcuit extends JPanel {
    protected BufferedImage background;
    private int width = 500;
    private int height = 400;

    public Ciurcuit() {
        super();
        super.setPreferredSize(new Dimension(width, height));
    }

    protected void setBackground(String path){
        try{
            background = ImageIO.read(new File(path));
        } 
        catch (Exception e){
            System.out.println("Circuit image not found");
        }
        Graphics g = getGraphics();
        g.drawImage(background, 0, 0, width, height, this);
    }

    public abstract boolean isSolved();
    protected abstract void randomizeComponentValues();
}
