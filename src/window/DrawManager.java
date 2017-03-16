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

        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        thickness = 1;
    }

    public void setDrawManager(JPanel drawPanel, JColorChooser colorChooser) {
        this.drawPanel = drawPanel;
        this.colorChooser = colorChooser;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void removeListeners() {
        drawPanel.removeMouseListener(drawPanel.getMouseListeners()[0]);
        drawPanel.removeMouseMotionListener(drawPanel.getMouseMotionListeners()[0]);
    }

    public Cursors getCursors() { return cursors; }
    public JPanel getDrawPanel() { return drawPanel; }
    public JColorChooser getColorChooser() { return colorChooser; }
    public BufferedImage getBufferedImage() { return bufferedImage; }
    public int getThickness() { return thickness; }
}