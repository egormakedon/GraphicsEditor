package instruments;

import javax.swing.*;
import java.awt.*;

public class Line {

    private JButton lineButton = new JButton();

    public Line() {
        lineButton.setBackground(Color.white);
        lineButton.setPreferredSize(new Dimension(32,32));
        lineButton.setIcon(new ImageIcon("images/line.png"));
    }

    public JButton getLineButton() {
        return lineButton;
    }
}