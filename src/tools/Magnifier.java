package tools;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Magnifier {

    private Cursor cursor;
    private JPanel drawPanel;
    private DrawManager drawManager;
    private BufferedImage bufferedImage;

    public Magnifier(DrawManager drawManager) {
        cursor = drawManager.getCursors().getMagnifierCursor();
        drawPanel = drawManager.getDrawPanel();
        bufferedImage = drawManager.getBufferedImage();

        this.drawManager = drawManager;
    }

    private MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }
    };

    private MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            drawManager.setNewBuf(scale(bufferedImage, drawManager.getThickness()));

            drawPanel.setSize(new Dimension(drawManager.getBufferedImage().getWidth(), drawManager.getBufferedImage().getHeight()));
            drawPanel.setPreferredSize(new Dimension(drawManager.getBufferedImage().getWidth(), drawManager.getBufferedImage().getHeight()));

            drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

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

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }
    public MouseListener getMouseListener() { return mouseListener; }
}