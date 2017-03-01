package colorPanel;

import javax.swing.*;
import java.awt.*;

public class Colors {

    private JMenuItem blackColor = new JMenuItem();
    private JMenuItem yellowColor = new JMenuItem();
    private JMenuItem greenColor = new JMenuItem();
    private JMenuItem redColor = new JMenuItem();
    private JMenuItem blueColor = new JMenuItem();
    private JMenuItem orangeColor = new JMenuItem();
    private JMenuItem greyColor = new JMenuItem();
    private JMenuItem pinkColor = new JMenuItem();
    private JMenuItem purpleColor = new JMenuItem();

    public void addColors(JMenu colorPanelMenu) {

        blackColor.setPreferredSize(new Dimension(120,24));
        yellowColor.setPreferredSize(new Dimension(120,24));
        greenColor.setPreferredSize(new Dimension(120,24));
        redColor.setPreferredSize(new Dimension(120,24));
        blueColor.setPreferredSize(new Dimension(120,24));
        orangeColor.setPreferredSize(new Dimension(120,24));
        greyColor.setPreferredSize(new Dimension(120,24));
        pinkColor.setPreferredSize(new Dimension(120,24));
        purpleColor.setPreferredSize(new Dimension(120,24));

        blackColor.setIcon(new ImageIcon("images/colors/black.png"));
        yellowColor.setIcon(new ImageIcon("images/colors/yellow.png"));
        greenColor.setIcon(new ImageIcon("images/colors/green.png"));
        redColor.setIcon(new ImageIcon("images/colors/red.png"));
        blueColor.setIcon(new ImageIcon("images/colors/blue.png"));
        orangeColor.setIcon(new ImageIcon("images/colors/orange.png"));
        greyColor.setIcon(new ImageIcon("images/colors/grey.png"));
        pinkColor.setIcon(new ImageIcon("images/colors/pink.png"));
        purpleColor.setIcon(new ImageIcon("images/colors/purple.png"));

        colorPanelMenu.add(blackColor);
        colorPanelMenu.add(yellowColor);
        colorPanelMenu.add(greenColor);
        colorPanelMenu.add(redColor);
        colorPanelMenu.add(blueColor);
        colorPanelMenu.add(orangeColor);
        colorPanelMenu.add(greyColor);
        colorPanelMenu.add(pinkColor);
        colorPanelMenu.add(purpleColor);
    }
}