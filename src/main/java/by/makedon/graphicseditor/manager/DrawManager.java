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
import java.util.HashMap;
import java.util.Map;

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

    public void paint() {
        drawPanel.getGraphics()
                 .drawImage(bufferedImage, 0, 0, drawPanel);
    }

    public void paint(BufferedImage bufferedImage) {
        drawPanel.getGraphics()
                 .drawImage(bufferedImage, 0, 0, drawPanel);
    }

    public void clearDrawPanel() {
        bufferedImage = initBufferedImage();
        paint();
    }

    //TODO do with colorchooser
    public Color getColor() {
        return Color.black;
    }

    //TODO with thickness param
    public Stroke getStroke() {
        return new BasicStroke(2.0f);
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

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    private BufferedImage initBufferedImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        BufferedImage bufferedImage = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.fillRect(0, 0, screenWidth, screenHeight);

        Map<Object, Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        g.setRenderingHints(hints);

        return bufferedImage;
    }

    private class DrawPanel extends JPanel {
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
