package tools;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Quadrangle {

    private Cursor cursor;
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;
    private DrawManager drawManager;

    private boolean isPressed = false;
    private int x1, x2, y1, y2, x3, y3;
    private float thickness;

    public Quadrangle(DrawManager drawManager) {
        cursor = drawManager.getCursors().getQuadrangleCursor();
        drawPanel = drawManager.getDrawPanel();
        colorChooser = drawManager.getColorChooser();
        bufferedImage = drawManager.getBufferedImage();

        this.drawManager = drawManager;
    }

    private MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (!isPressed) {
                x3 = x1 = e.getX();
                y3 = y1 = e.getY();
                thickness = drawManager.getThickness() * 2.0f;
            }

            isPressed = true;
            x2 = e.getX();
            y2 = e.getY();

            paint();

            x3 = x2;
            y3 = y2;
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

        }

        @Override
        public void mouseReleased(MouseEvent e) {
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
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();

        g.setColor(Color.white);
        g.setStroke(new BasicStroke(thickness));

        g.fillRect(x1, y1,x3 - x1,y3 - y1);
        g.fillRect(x1, y1,x3 - x1,y1 - y3);
        g.fillRect(x1, y1,x3 - x1,y3 - y1);
        g.fillRect(x1, y1,x3 - x1,y3 - y1);


        g.setColor(colorChooser.getColor());
        g.setStroke(new BasicStroke(drawManager.getThickness() * 2.0f));

        g.fillRect(x1, y1,x2 - x1,y2 - y1);
        g.fillRect(x1, y1,x3 - x1,y1 - y3);

        drawPanel.getGraphics().drawImage(bufferedImage,0,0, drawPanel);

        thickness = drawManager.getThickness() * 2.0f;
    }

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }
    public MouseListener getMouseListener() { return mouseListener; }
}