package tools;

import javax.swing.*;
import java.awt.*;

public class Eraser {

    private JButton eraserButton = new JButton();

    public Eraser() {
        eraserButton.setBackground(Color.white);
        eraserButton.setPreferredSize(new Dimension(32,32));
        eraserButton.setIcon(new ImageIcon("images/eraser.png"));
    }

    public JButton getEraserButton() {
        return eraserButton;
    }
}