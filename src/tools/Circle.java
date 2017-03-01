package tools;

import javax.swing.*;
import java.awt.*;

public class Circle {

    private JButton circleButton = new JButton();

    public Circle() {
        circleButton.setBackground(Color.white);
        circleButton.setPreferredSize(new Dimension(32,32));
        circleButton.setIcon(new ImageIcon("images/circle.png"));
    }

    public JButton getCircleButton() {
        return circleButton;
    }
}