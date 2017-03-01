package tools;

import javax.swing.*;
import java.awt.*;

public class Eraser {

    private JButton eraserButton = new JButton();
    private JMenuItem eraserMenuItem = new JMenuItem("eraser");

    public Eraser() {
        eraserButton.setBackground(Color.gray);
        eraserButton.setPreferredSize(new Dimension(32,32));
        eraserButton.setIcon(new ImageIcon("images/eraser.png"));

        eraserMenuItem.setIcon(new ImageIcon("images/eraser.png"));
    }

    public JButton getEraserButton() {
        return eraserButton;
    }
    public JMenuItem getEraserMenuItem() { return eraserMenuItem; }
}