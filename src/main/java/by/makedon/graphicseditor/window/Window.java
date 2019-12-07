package by.makedon.graphicseditor.window;

import by.makedon.graphicseditor.frame.AddTools;
import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.util.ResourceUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public class Window {
    private JFrame jFrame;

    public Window() {
        jFrame = createJFrame();
    }

    public void show() {
        jFrame.setVisible(true);
    }

    private JFrame createJFrame() {
        String frameName = ResourceUtil.getPropertyValue(Constants.FRAME_NAME);
        int frameMinimumWidth = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.FRAME_MINIMUM_WIDTH));
        int frameMinimumHeight = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.FRAME_MINIMUM_HEIGHT));

        JFrame jFrame = new JFrame(frameName);
        jFrame.setMinimumSize(new Dimension(frameMinimumWidth, frameMinimumHeight));
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        jFrame.setJMenuBar(createJMenuBar());

//        JPanel drawPanel = new NewPanel();
//        JScrollPane scrollPane = new JScrollPane(drawPanel);
//        frame.add(scrollPane, BorderLayout.CENTER);
//        addTools = new AddTools(drawPanel);
//        addTools.setBars(menuBar, toolBar);

        return jFrame;
    }

    private JMenuBar createJMenuBar() {
        String menuBarColor = ResourceUtil.getPropertyValue(Constants.MENUBAR_COLOR);
        int menuBarWidth = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.MENUBAR_WIDTH));
        int menuBarHeight = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.MENUBAR_HEIGHT));

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setBackground(Color.decode(menuBarColor));
        jMenuBar.setPreferredSize(new Dimension(menuBarWidth, menuBarHeight));
        jMenuBar.setBorder(BorderFactory.createEtchedBorder());
        return jMenuBar;
    }

//    public class NewPanel extends JPanel {
//        @Override
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(addTools.getDrawManager().getBufferedImage(),0,0,this);
//        }
//    }
}
