package by.makedon.graphicseditor.manager;

import by.makedon.graphicseditor.tool.Tool;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public final class DrawManager {
    private static DrawManager instance;

    private DrawPanel drawPanel;
    private Tool tool;

    private DrawManager() {
        drawPanel = new DrawPanel();
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

    private class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//            g.drawImage(addTools.getDrawManager().getBufferedImage(),0,0,this);
        }
    }
}
