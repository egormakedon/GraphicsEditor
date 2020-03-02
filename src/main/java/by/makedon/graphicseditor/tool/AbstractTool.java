package by.makedon.graphicseditor.tool;

import by.makedon.graphicseditor.manager.DrawManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * @author Yahor Makedon
 */
public abstract class AbstractTool implements Tool {
    protected void drawImage() {
        DrawManager.getInstance().drawImage();
    }

    protected void drawImage(BufferedImage bufferedImage) {
        DrawManager.getInstance().drawImage(bufferedImage);
    }

    protected void copyOriginalImageTo(BufferedImage bufferedImage) {
        bufferedImage.getGraphics().drawImage(DrawManager.getInstance().getBufferedImage(), 0, 0, null);
    }

    protected BufferedImage createBufferedImage() {
        return DrawManager.getInstance().createBufferedImage();
    }

    protected Graphics2D getGraphics2D() {
        return getGraphics2D(DrawManager.getInstance().getBufferedImage());
    }

    protected Graphics2D getGraphics2D(BufferedImage bufferedImage) {
        return (Graphics2D) bufferedImage.getGraphics();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
