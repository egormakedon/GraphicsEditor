package tools;

import javax.swing.*;
import java.awt.*;

public class Quadrangle {

    private JButton quadrangleButton = new JButton();

    public Quadrangle() {
        quadrangleButton.setBackground(Color.white);
        quadrangleButton.setPreferredSize(new Dimension(32,32));
        quadrangleButton.setIcon(new ImageIcon("images/quadrangle.png"));
    }

    public JButton getQuadrangleButton() {
        return quadrangleButton;
    }
}