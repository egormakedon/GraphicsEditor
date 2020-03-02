package by.makedon.graphicseditor.tool.impl;

import by.makedon.graphicseditor.tool.AbstractTool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author Yahor Makedon
 */
public class Pencil extends AbstractTool {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    @Override
    public void mouseClicked(MouseEvent e) {
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        paint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        paint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //TODO setting cursor: drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //TODO setting cursor: drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        paint();

        x1 = x2;
        y1 = y2;
    }

    private void paint() {
        drawLine(getGraphics2D());
        drawImage();
    }

    private void drawLine(Graphics2D g) {
        g.drawLine(x1, y1, x2, y2);
    }
}
