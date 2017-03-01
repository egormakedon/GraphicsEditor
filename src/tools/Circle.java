package tools;

import javax.swing.*;
import java.awt.*;

public class Circle {

    private JButton circleButton = new JButton();
    private JMenuItem circleMenuItem = new JMenuItem("circle");

    public Circle() {
        circleButton.setBackground(Color.gray);
        circleButton.setPreferredSize(new Dimension(32,32));
        circleButton.setIcon(new ImageIcon("images/circle.png"));

        circleMenuItem.setIcon(new ImageIcon("images/circle.png"));
    }

    public JButton getCircleButton() {
        return circleButton;
    }
    public JMenuItem getCircleMenuItem() { return circleMenuItem; }
}