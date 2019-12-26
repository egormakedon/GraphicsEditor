package by.makedon.graphicseditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Magnifier {

    private Cursor cursor;
    private JPanel drawPanel;
    private DrawManager drawManager;

    public Magnifier(DrawManager drawManager) {
        cursor = drawManager.getCursors().getMagnifierCursor();
        drawPanel = drawManager.getDrawPanel();

        this.drawManager = drawManager;
    }

    private MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {

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
            drawManager.setNewBuf(drawManager.getBufferedImage(), drawManager.getThickness());

            drawPanel.setSize(new Dimension(drawManager.getBufferedImage().getWidth(), drawManager.getBufferedImage().getHeight()));
            drawPanel.setPreferredSize(new Dimension(drawManager.getBufferedImage().getWidth(), drawManager.getBufferedImage().getHeight()));

            drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }
    public MouseListener getMouseListener() { return mouseListener; }
}
