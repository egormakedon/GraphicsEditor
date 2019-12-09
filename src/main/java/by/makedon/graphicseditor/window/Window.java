package by.makedon.graphicseditor.window;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.util.ResourceUtil;
import by.makedon.graphicseditor.window.menubar.MenuBar;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public class Window extends JFrame {
    public Window() {
        String frameName = ResourceUtil.getPropertyValue(Constants.FRAME_NAME);
        int frameMinimumWidth = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.FRAME_MINIMUM_WIDTH));
        int frameMinimumHeight = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.FRAME_MINIMUM_HEIGHT));

        setTitle(frameName);
        setMinimumSize(new Dimension(frameMinimumWidth, frameMinimumHeight));
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar());
    }

    public void showWindow() {
        setVisible(true);
    }

    private void createJFrame() {
//        JPanel drawPanel = new NewPanel();
//        JScrollPane scrollPane = new JScrollPane(drawPanel);
//        frame.add(scrollPane, BorderLayout.CENTER);
//        addTools = new AddTools(drawPanel);
//        addTools.setBars(menuBar, toolBar);
    }

//    public class NewPanel extends JPanel {
//        @Override
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(addTools.getDrawManager().getBufferedImage(),0,0,this);
//        }
//    }
}
