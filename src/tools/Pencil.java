package tools;

import javax.swing.*;
import java.awt.*;

public class Pencil {

    private JButton pencilButton = new JButton();

    public Pencil() {
        pencilButton.setBackground(Color.white);
        pencilButton.setPreferredSize(new Dimension(32,32));
        pencilButton.setIcon(new ImageIcon("images/pencil.png"));
    }

    public JButton getPencilButton() { return pencilButton; }
}