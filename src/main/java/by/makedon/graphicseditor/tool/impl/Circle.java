package by.makedon.graphicseditor.tool.impl;

import by.makedon.graphicseditor.tool.AbstractTool;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * @author Yahor Makedon
 */
public class Circle extends AbstractTool {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private BufferedImage savedBufferedImage;

    @Override
    public void mousePressed(MouseEvent e) {
        savedBufferedImage = createBufferedImage();

        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        paint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawOval(getGraphics2D());
        drawImage();

        savedBufferedImage = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //TODO drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //TODO drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        paint();
    }

    private void paint() {
        copyOriginalImageTo(savedBufferedImage);
        drawOval(getGraphics2D(savedBufferedImage));
        drawImage(savedBufferedImage);
    }

    private void drawOval(Graphics2D g) {
        if (x1 < x2 && y1 < y2) {
            g.drawOval(x1, y1, x2 - x1, y2 - y1);
        } else if (x1 < x2 && y1 > y2) {
            g.drawOval(x1, y2, x2 - x1, y1 - y2);
        } else if (x1 > x2 && y1 > y2) {
            g.drawOval(x2, y2, x1 - x2, y1 - y2);
        } else if (x1 > x2 && y1 < y2) {
            g.drawOval(x2, y1, x1 - x2, y2 - y1);
        }
    }
}
