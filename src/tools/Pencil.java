package tools;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pencil implements ActionListener, MouseMotionListener, MouseListener {

    private DrawManager drawManager;
    private Cursor cursor;
    private JPanel drawPanel;
    boolean isPressed = false;
    int x1, x2, y1, y2;

    public Pencil() {
        this.drawManager = drawManager;

        /*cursor = this.drawManager.getCursors().getPencilCursor();
        drawPanel = this.drawManager.getDrawPanel();*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drawPanel.setCursor(cursor);
    }

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isPressed) {
            x1 = (int) drawPanel.getMousePosition().getX();
            y1 = (int) drawPanel.getMousePosition().getY();
            drawPanel.getGraphics().drawLine(x1,y1,x1,y1);
        }

        else {
            x2 = (int) drawPanel.getMousePosition().getX();
            y2 = (int) drawPanel.getMousePosition().getY();
            drawPanel.getGraphics().drawLine(x1,y1,x2,y2);
        }

        isPressed = true;
        x1 = x2;
        y1 = y2;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void zalupa() {

    }
}