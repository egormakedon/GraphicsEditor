package tools;

import javax.swing.*;
import java.awt.*;

public class Quadrangle {

    private JButton quadrangleButton = new JButton();
    public JMenuItem quadrangleMenuItem = new JMenuItem("quadrangle");

    public Quadrangle() {
        quadrangleButton.setBackground(Color.gray);
        quadrangleButton.setPreferredSize(new Dimension(32,32));
        quadrangleButton.setIcon(new ImageIcon("images/quadrangle.png"));

        quadrangleMenuItem.setIcon(new ImageIcon("images/quadrangle.png"));
    }

    public JButton getQuadrangleButton() {
        return quadrangleButton;
    }
    public JMenuItem getQuadrangleMenuItem() { return quadrangleMenuItem; }
}