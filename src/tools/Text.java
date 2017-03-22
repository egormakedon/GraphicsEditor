package tools;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Text {

    private Cursor cursor;
    private JPanel drawPanel;
    private JColorChooser colorChooser;
    private BufferedImage bufferedImage;
    private DrawManager drawManager;

    private int x1, y1;

    public Text(DrawManager drawManager) {
        cursor = new Cursor(Cursor.TEXT_CURSOR);
        drawPanel = drawManager.getDrawPanel();
        colorChooser = drawManager.getColorChooser();
        bufferedImage = drawManager.getBufferedImage();

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
            x1 = e.getX();
            y1 = e.getY() - 12;
            paint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

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

    public void paint() {
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(2.0f));
        g.drawRect(x1, y1,200,26);

        g.setColor(colorChooser.getColor());
        g.setFont(new Font("Calibri", Font.PLAIN, (int)(drawManager.getThickness() * 15.0f)));
        g.drawString(new String("xxxx"),x1 + 2,y1 + 23);

        drawPanel.getGraphics().drawImage(bufferedImage,0,0, drawPanel);
    }

    public MouseMotionListener getMouseMotionListener() { return mouseMotionListener; }
    public MouseListener getMouseListener() { return mouseListener; }
}