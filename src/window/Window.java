package window;

import frame.*;
import frame.Frame;
import frame.MenuBar;

import javax.swing.*;
import java.awt.*;

public class Window {

    private Frame frame = new Frame();
    private MenuBar menuBar = new MenuBar();
    private ToolBar toolBar = new ToolBar();
    private DrawPanel drawPanel = new DrawPanel();

    private AddTools addTools;

    public Window() {
        JFrame frame = this.frame.getFrame();
        JMenuBar menuBar = this.menuBar.getMenuBar();
        JPanel toolBar = this.toolBar.getToolBar();
        JPanel drawPanel = this.drawPanel.getDrawPanel();

        addTools = new AddTools(drawPanel);
        addTools.setBars(menuBar, toolBar);

        frame.add(drawPanel);
        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.WEST);
        frame.setVisible(true);
    }
}