package tools;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Pencil {

    private Cursor cursor;
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;
    private DrawManager drawManager;

    private boolean isPressed = false;
    private int x1, x2, y1, y2;

    public Pencil(DrawManager drawManager) {
        cursor = drawManager.getCursors().getPencilCursor();
        drawPanel = drawManager.getDrawPanel();
        colorChooser = drawManager.getColorChooser();
        bufferedImage = drawManager.getBufferedImage();

        this.drawManager = drawManager;
    }

    public void setFunction() {

        drawPanel.addMouseMotionListener(new MouseMotionListener() {
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
        });

        drawPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                paint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                paint();
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
        });
    }

    public void paint() {
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();

        g.setColor(colorChooser.getColor());
        g.setStroke(new BasicStroke(drawManager.getThickness() * 2.0f));

        if (isPressed) {
            g.drawLine(x1, y1, x2, y2);
        }

        else {
            g.drawLine(x1, y1, x1, y1);
        }

        drawPanel.getGraphics().drawImage(bufferedImage,0,0, drawPanel);
    }
}