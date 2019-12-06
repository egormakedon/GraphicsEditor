package by.makedon.graphicseditor.frame;

import javax.swing.*;
import java.awt.*;

public class Frame {

    private JFrame frame = new JFrame("Graphics Editor");

    public Frame() {
        frame.setMinimumSize(new Dimension(800,600));
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public JFrame getFrame() { return frame; }
}
