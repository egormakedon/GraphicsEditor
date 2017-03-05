package tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pencil {

    private JButton pencilButton = new JButton();
    private JMenuItem pencilMenuItem = new JMenuItem("pencil");

    public Pencil() {
        pencilButton.setBackground(Color.gray);
        pencilButton.setPreferredSize(new Dimension(32,32));
        pencilButton.setIcon(new ImageIcon("images/pencil.png"));

        pencilMenuItem.setIcon(new ImageIcon("images/pencil.png"));
    }

    public void pencilFunction(JPanel drawPanel) {

    }

    public JButton getPencilButton() { return pencilButton; }
    public JMenuItem getPencilMenuItem() { return pencilMenuItem; }
}