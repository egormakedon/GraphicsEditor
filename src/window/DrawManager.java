package window;

import cursors.Cursors;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawManager {

    private Cursors cursors = new Cursors();
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;
    private int thickness;

    public DrawManager() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        bufferedImage = new BufferedImage((int) screenSize.getWidth(), (int) screenSize.getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().fillRect(0,0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

        thickness = 1;
    }

    public void setDrawManager(JPanel drawPanel, JColorChooser colorChooser) {
        this.drawPanel = drawPanel;
        this.colorChooser = colorChooser;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Cursors getCursors() { return cursors; }
    public JPanel getDrawPanel() { return drawPanel; }
    public JColorChooser getColorChooser() { return colorChooser; }
    public BufferedImage getBufferedImage() { return bufferedImage; }
    public int getThickness() { return thickness; }
}