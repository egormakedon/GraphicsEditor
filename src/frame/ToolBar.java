package frame;

import javax.swing.*;
import java.awt.*;

public class ToolBar {

    private JPanel toolBar = new JPanel();

    public ToolBar() {
        toolBar.setBackground(Color.gray);
        toolBar.setBorder(BorderFactory.createEtchedBorder());
        toolBar.setLayout(new GridBagLayout());
    }

    public JPanel getToolBar() { return toolBar; }
}