import javax.swing.JPanel;

abstract class Ciurcuit extends JPanel {
    public Ciurcuit() {
        super();
    }

    public abstract boolean isSolved();
    protected abstract void randomizeComponentValues();
}
