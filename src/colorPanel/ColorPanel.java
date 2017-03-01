package colorPanel;

import javax.swing.*;
import java.awt.*;

public class ColorPanel {

    private JMenu colorPanel = new JMenu();
    private Colors colors = new Colors();

    public ColorPanel () {
        colorPanel.setPreferredSize(new Dimension(120,24));
        colorPanel.setIcon(new ImageIcon("images/colors/black.png"));

        colors.addColors(colorPanel);
    }

    public JMenu getColorPanel() { return colorPanel; }
    public Colors getColors() { return colors; }
}