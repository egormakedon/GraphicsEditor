package tools;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Line {

    private Cursor cursor;
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;
    private DrawManager drawManager;

    private boolean isPressed = false;
    private int x1, x2, y1, y2;
    private BufferedImage transparentBufImg;

    public Line(DrawManager drawManager) {
        cursor = drawManager.getCursors().getLineCursor();
        drawPanel = drawManager.getDrawPanel();
        colorChooser = drawManager.getColorChooser();
        bufferedImage = drawManager.getBufferedImage();

        this.drawManager = drawManager;
    }

    private MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (!isPressed) {
                x1 = e.getX();
                y1 = e.getY();
            }

            isPressed = true;
            x2 = e.getX();
            y2 = e.getY();

            paint();
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
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            transparentBufImg = new BufferedImage((int) screenSize.getWidth(), (int) screenSize.getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
            g.setColor(colorChooser.getColor());
            g.setStroke(new BasicStroke(drawManager.getThickness() * 2.0f));
            g.drawLine(x1, y1, x2, y2);
            drawPanel.getGraphics().drawImage(bufferedImage,0,0, drawPanel);

            isPressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public void paint() {
        transparentBufImg.getGraphics().drawImage(bufferedImage,0,0, drawPanel);

        Graphics2D g = (Graphics2D) transparentBufImg.getGraphics();

        g.setColor(colorChooser.getColor());
        g.setStroke(new BasicStroke(drawManager.getThickness() * 2.0f));
        g.drawLine(x1, y1, x2, y2);

        drawPanel.getGraphics().drawImage(transparentBufImg,0,0, drawPanel);
    }

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }
    public MouseListener getMouseListener() { return mouseListener; }
}