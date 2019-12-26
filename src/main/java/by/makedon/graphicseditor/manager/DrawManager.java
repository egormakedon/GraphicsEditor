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

    private JComponent drawPanel;
    private BufferedImage bufferedImage;
    private Tool tool;
    private Color color;
    private int thickness;

    private DrawManager() {
        drawPanel = new DrawPanel();
        bufferedImage = createBufferedImage();
        tool = ToolManager.getInstance().getTool(Pencil.class);
        color = Color.BLACK;
        //TODO thickness start value
    }

    public static DrawManager getInstance() {
        if (instance == null) {
            instance = new DrawManager();
        }
        return instance;
    }

    public void clearDrawPanel() {
        bufferedImage = createBufferedImage();
        drawImage();
    }

    public void drawImage() {
        drawImage(bufferedImage);
    }

    public void drawImage(BufferedImage bufferedImage) {
        drawPanel.getGraphics().drawImage(bufferedImage, 0, 0, drawPanel);
    }

    public BufferedImage createBufferedImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        return new CustomBufferedImage(screenWidth, screenHeight);
    }

    public JComponent getDrawPanel() {
        return drawPanel;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Tool getTool() {
        return tool;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    private final class CustomBufferedImage extends BufferedImage {
        private CustomBufferedImage(int screenWidth, int screenHeight) {
            super(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
            getGraphics().fillRect(0, 0, screenWidth, screenHeight);
        }

        @Override
        public Graphics getGraphics() {
            Graphics2D g = (Graphics2D) super.getGraphics();
            g.setColor(color);
            g.setStroke(new BasicStroke(thickness));
            return g;
        }
    }

    private final class DrawPanel extends JComponent {
        private DrawPanel() {
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

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }
}
