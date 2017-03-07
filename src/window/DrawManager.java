package window;

import cursors.Cursors;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class DrawManager {

    private Cursors cursors = new Cursors();
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;

    public void setDrawManager(JPanel drawPanel, JColorChooser colorChooser) {
        this.drawPanel = drawPanel;
        this.colorChooser = colorChooser;

        bufferedImage = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().fillRect(0,0, drawPanel.getWidth(), drawPanel.getHeight());
    }

    public Cursors getCursors() { return cursors; }
    public JPanel getDrawPanel() { return drawPanel; }
    public JColorChooser getColorChooser() { return colorChooser; }
    public BufferedImage getBufferedImage() { return bufferedImage; }
}