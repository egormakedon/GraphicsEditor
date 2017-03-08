package frame;

import javax.swing.*;
import java.awt.*;

public class DrawPanel {

    private JPanel drawPanel = new JPanel();

    public DrawPanel() {
        drawPanel.setBackground(Color.white);
    }

    public JPanel getDrawPanel() { return drawPanel; }
}