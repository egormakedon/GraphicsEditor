package tools;

import javax.swing.*;
import java.awt.*;

public class Magnifier {

    private JButton magnifierButton = new JButton();
    private JMenuItem magnifierMenuItem = new JMenuItem("magnifier");

    public Magnifier() {
        magnifierButton.setBackground(Color.gray);
        magnifierButton.setPreferredSize(new Dimension(32,32));
        magnifierButton.setIcon(new ImageIcon("images/magnifier.png"));

        magnifierMenuItem.setIcon(new ImageIcon("images/magnifier.png"));
    }

    public JButton getMagnifierButton() { return magnifierButton; }
    public JMenuItem getMagnifierMenuItem() { return magnifierMenuItem; }
}