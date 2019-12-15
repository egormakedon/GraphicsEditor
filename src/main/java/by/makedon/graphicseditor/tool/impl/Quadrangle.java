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
    private boolean isMousePressed;
    private int x1, x2, y1, y2;
    private BufferedImage savedBufferedImage;

    @Override
    public void init() {
        isMousePressed = false;
        x1 = x2 = y1 = y2 = 0;
        savedBufferedImage = null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawRect(DrawManager.getInstance().getGraphics());
        DrawManager.getInstance().paint();

        init();
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

        if (!isMousePressed) {
            isMousePressed = true;

            savedBufferedImage = DrawManager.getInstance().createNewBufferedImage();

            x1 = x2;
            y1 = y2;
        }

        paint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //TODO drawPanel.setCursor(cursor);
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
