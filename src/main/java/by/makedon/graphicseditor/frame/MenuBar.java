package by.makedon.graphicseditor.frame;

import javax.swing.*;
import java.awt.*;

public class MenuBar {

    private JMenuBar menuBar = new JMenuBar();

    public MenuBar() {
        menuBar.setBackground(Color.gray);
        menuBar.setPreferredSize(new Dimension(0, 30));
        menuBar.setBorder(BorderFactory.createEtchedBorder());
    }

    public JMenuBar getMenuBar() { return menuBar; }
}
