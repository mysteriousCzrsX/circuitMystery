import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

import java.awt.Graphics;

public class Circuit1 extends Ciurcuit {
    JTextField value1 = new JTextField();
    public Circuit1() {
        super();
        //setBackground("assets/circuit1.png");
    }

    @Override
    public boolean isSolved() {
        return false;
    }

    @Override
    protected void randomizeComponentValues() {

    }
    
}
