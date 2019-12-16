package by.makedon.graphicseditor.tool.impl;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.AbstractTool;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * @author Yahor Makedon
 */
public class Quadrangle extends AbstractTool {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private BufferedImage savedBufferedImage;

    @Override
    public void mousePressed(MouseEvent e) {
        savedBufferedImage = DrawManager.getInstance().createNewBufferedImage();

        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        paint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawRect(DrawManager.getInstance().getGraphics());
        DrawManager.getInstance().paint();

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
        DrawManager.getInstance().copyOriginalImageTo(savedBufferedImage);
        drawRect(DrawManager.getInstance().getGraphics(savedBufferedImage));
        DrawManager.getInstance().paint(savedBufferedImage);
    }

    private void drawRect(Graphics2D g) {
        if (x1 < x2 && y1 < y2) {
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        } else if (x1 < x2 && y1 > y2) {
            g.drawRect(x1, y2, x2 - x1, y1 - y2);
        } else if (x1 > x2 && y1 > y2) {
            g.drawRect(x2, y2, x1 - x2, y1 - y2);
        } else if (x1 > x2 && y1 < y2) {
            g.drawRect(x2, y1, x1 - x2, y2 - y1);
        }
    }
}
