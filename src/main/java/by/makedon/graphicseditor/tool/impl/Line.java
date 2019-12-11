package by.makedon.graphicseditor.tool.impl;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.AbstractTool;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * @author Yahor Makedon
 */
public class Line extends AbstractTool {
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
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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

        init();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //TODO cursor drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //TODO cursor drawPanel.setCursor(cursor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        if (!isMousePressed) {
            isMousePressed = true;

            BufferedImage bufferedImage = DrawManager.getInstance().getBufferedImage();
            ColorModel colorModel = bufferedImage.getColorModel();
            savedBufferedImage = new BufferedImage(colorModel, bufferedImage.copyData(null),
                    colorModel.isAlphaPremultiplied(), null);

            x1 = x2;
            y1 = y2;
        }

        paint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //TODO cursor drawPanel.setCursor(cursor);
    }

    private void paint() {
        savedBufferedImage.getGraphics()
                          .drawImage(DrawManager.getInstance()
                                                .getBufferedImage(), 0, 0, null);

        Graphics2D g = (Graphics2D) savedBufferedImage.getGraphics();

        g.setColor(DrawManager.getInstance()
                              .getColor());
        g.setStroke(DrawManager.getInstance()
                               .getStroke());
        g.drawLine(x1, y1, x2, y2);

        DrawManager.getInstance()
                   .paint(savedBufferedImage);
    }
}
