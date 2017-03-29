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

    private AddTools addTools;

    public Window() {
        JFrame frame = this.frame.getFrame();
        JMenuBar menuBar = this.menuBar.getMenuBar();
        JPanel toolBar = this.toolBar.getToolBar();
        JPanel drawPanel = new NewPanel();
        JScrollPane scrollPane = new JScrollPane(drawPanel);

        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

        addTools = new AddTools(drawPanel);
        addTools.setBars(menuBar, toolBar);

        frame.setVisible(true);
    }

    public class NewPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(addTools.getDrawManager().getBufferedImage(),0,0,this);
        }
    }
}