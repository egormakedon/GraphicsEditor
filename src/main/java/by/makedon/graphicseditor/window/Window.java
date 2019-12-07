package by.makedon.graphicseditor.window;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public class Window {
    private JFrame jFrame;

    public Window() {
        JFrame frame = this.frame.getFrame();
        JMenuBar menuBar = this.menuBar.getMenuBar();
        JPanel toolBar = this.toolBar.getToolBar();
        JPanel drawPanel = new NewPanel();
        JScrollPane scrollPane = new JScrollPane(drawPanel);

        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

//        addTools = new AddTools(drawPanel);
//        addTools.setBars(menuBar, toolBar);


    }

    public void show() {
        jFrame.setVisible(true);
    }

//    public class NewPanel extends JPanel {
//        @Override
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(addTools.getDrawManager().getBufferedImage(),0,0,this);
//        }
//    }
}
