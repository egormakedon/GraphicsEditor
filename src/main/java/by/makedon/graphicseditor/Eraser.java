package by.makedon.graphicseditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Eraser {

    private Cursor cursor;
    private JPanel drawPanel;
    private DrawManager drawManager;

    private boolean isPressed = false;
    private int x1, x2, y1, y2;

    public Eraser(DrawManager drawManager) {
        cursor = drawManager.getCursors().getEraserCursor();
        drawPanel = drawManager.getDrawPanel();

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

            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }
    };

    private MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
            paint();
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
        Graphics2D g = (Graphics2D) drawManager.getBufferedImage().getGraphics();

        g.setColor(Color.white);
        g.setStroke(new BasicStroke(drawManager.getThickness() * 20.0f));

        if (isPressed) {
            g.drawLine(x1, y1, x2, y2);
        }

        else {
            g.drawLine(x1, y1, x1, y1);
        }

        drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
    }

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }
    public MouseListener getMouseListener() { return mouseListener; }
}
