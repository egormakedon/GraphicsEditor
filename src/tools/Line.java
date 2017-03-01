package tools;

import javax.swing.*;
import java.awt.*;

public class Line {

    private JButton lineButton = new JButton();
    private JMenuItem lineMenuItem = new JMenuItem("line");

    public Line() {
        lineButton.setBackground(Color.gray);
        lineButton.setPreferredSize(new Dimension(32,32));
        lineButton.setIcon(new ImageIcon("images/line.png"));

        lineMenuItem.setIcon(new ImageIcon("images/line.png"));
    }

    public JButton getLineButton() {
        return lineButton;
    }
    public JMenuItem getLineMenuItem() { return lineMenuItem; }
}