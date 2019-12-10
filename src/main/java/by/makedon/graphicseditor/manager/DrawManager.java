package by.makedon.graphicseditor.manager;

import by.makedon.graphicseditor.tool.Tool;
import by.makedon.graphicseditor.tool.ToolManager;
import by.makedon.graphicseditor.tool.impl.Pencil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

/**
 * @author Yahor Makedon
 */
public final class DrawManager {
    private static DrawManager instance;

    private DrawPanel drawPanel;
    private Tool tool;
    private BufferedImage bufferedImage;

    private DrawManager() {
        drawPanel = new DrawPanel();
        tool = ToolManager.getInstance()
                          .getTool(Pencil.class);
        bufferedImage = initBufferedImage();
    }

    public static DrawManager getInstance() {
        if (instance == null) {
            instance = new DrawManager();
        }
        return instance;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Tool getTool() {
        return tool;
    }

    //TODO Remove if don't need externally
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    //TODO test method
    public void draw() {
        drawPanel.getGraphics().drawImage(bufferedImage, 0, 0, drawPanel);
    }

    private BufferedImage initBufferedImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        BufferedImage bufferedImage = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.fillRect(0, 0, screenWidth, screenHeight);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        return bufferedImage;
    }

    //TODO to private
    public class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tool.mouseClicked(e);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    tool.mousePressed(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    tool.mouseReleased(e);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    tool.mouseEntered(e);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    tool.mouseExited(e);
                }
            });

            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    tool.mouseDragged(e);
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    tool.mouseMoved(e);
                }
            });
        }
    }
}
