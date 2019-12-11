package by.makedon.graphicseditor.tool.impl;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.AbstractTool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author Yahor Makedon
 */
public class Pencil extends AbstractTool {
    private boolean isMousePressed;
    private int x1, x2, y1, y2;

    @Override
    public void init() {
        isMousePressed = false;
        x1 = x2 = y1 = y2 = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        paint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        init();
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

        if (isMousePressed) {
            paint();

            x1 = x2;
            y1 = y2;
        } else {
            isMousePressed = true;

            x1 = x2;
            y1 = y2;

            paint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //TODO setting cursor: drawPanel.setCursor(cursor);
    }

    private void paint() {
        Graphics2D g = (Graphics2D) DrawManager.getInstance()
                                               .getBufferedImage()
                                               .getGraphics();

        g.setColor(DrawManager.getInstance()
                              .getColor());
        g.setStroke(DrawManager.getInstance()
                               .getStroke());
        g.drawLine(x1, y1, x2, y2);

        DrawManager.getInstance()
                   .paint();
    }
}
