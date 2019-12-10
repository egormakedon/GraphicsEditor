package by.makedon.graphicseditor.tool.impl;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.AbstractTool;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Pencil extends AbstractTool {

//    private Cursor cursor;
//    private JPanel drawPanel;
//    private JColorChooser colorChooser;
//    private DrawManager drawManager;

    private boolean isPressed = false;
    private int x1, x2, y1, y2;

    public Pencil() {
//        cursor = drawManager.getCursors().getPencilCursor();
//        drawPanel = drawManager.getDrawPanel();
//        colorChooser = drawManager.getColorChooser();
//
//        this.drawManager = drawManager;
    }

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
//        drawPanel.setCursor(cursor);
    }

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
//        drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void paint() {
        Graphics2D g = (Graphics2D) DrawManager.getInstance().getBufferedImage().getGraphics();

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(2.0f));
//        g.setColor(colorChooser.getColor());
//        g.setStroke(new BasicStroke(drawManager.getThickness() * 2.0f));

        if (isPressed) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            g.drawLine(x1, y1, x1, y1);
        }

        DrawManager.getInstance().draw();

//        JPanel drawPanel = DrawManager.getInstance().getDrawPanel();
//        drawPanel.getGraphics().drawImage(DrawManager.getInstance().getBufferedImage(), 0, 0, drawPanel);
    }
}
