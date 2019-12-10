package by.makedon.graphicseditor;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class DrawManager {

    private Cursors cursors = new Cursors();
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;
    private int thickness = 1;
    private double zoom = 1;

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void removeListeners() {
        drawPanel.removeMouseListener(drawPanel.getMouseListeners()[0]);
        drawPanel.removeMouseMotionListener(drawPanel.getMouseMotionListeners()[0]);
    }

    public void setNewBuf(BufferedImage buf, double zoom) {
       if (zoom == 1) {
           bufferedImage = scale(buf,1 / this.zoom);
           this.zoom = zoom;
           return;
       }

        if (zoom == 2) {
            bufferedImage = scale(buf,1 / this.zoom);
            bufferedImage = scale(buf, zoom);
            this.zoom = zoom;
            return;
        }

        if (zoom == 3) {
            bufferedImage = scale(buf,1 / this.zoom);
            bufferedImage = scale(buf, zoom);
            this.zoom = zoom;
            return;
        }
    }

    public BufferedImage scale(BufferedImage input, double coefficient) {
        int inW = input.getWidth();
        int inH = input.getHeight();
        int outW = (int) (inW * coefficient);
        int outH = (int) (inH * coefficient);

        BufferedImage res = new BufferedImage(outW, outH, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < outW; x++) {
            for (int y = 0; y < outH; y++) {
                int cl = input.getRGB(x * inW / outW, y * inH / outH);
                res.setRGB(x, y, cl);
            }
        }

        return res;
    }

    public Cursors getCursors() { return cursors; }
    public JPanel getDrawPanel() { return drawPanel; }
    public JColorChooser getColorChooser() { return colorChooser; }
    public BufferedImage getBufferedImage() { return bufferedImage; }
    public int getThickness() { return thickness; }
}
