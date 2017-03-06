package frame;

import window.DrawManager;

import javax.swing.*;
import java.awt.*;

public class AddTools {

    private JPanel drawPanel;
    private DrawManager drawManager = new DrawManager();

    private JMenu menu = new JMenu("menu");
    private JMenu toolsMenu = new JMenu("tools");

    public AddTools(JPanel drawPanel) {
        menu.setIcon(new ImageIcon("images/menu.png"));
        toolsMenu.setIcon(new ImageIcon("images/toolsMenu.png"));

        this.drawPanel = drawPanel;
    }

    public void setBars (JMenuBar menuBar, JPanel toolBar) {
        setMenuTools(menuBar);
        setTools(toolBar);
    }

    public void setMenuTools(JMenuBar menuBar) {
        menu.add(setToolItem("","open"));
        menu.add(setToolItem("","save as"));
        menu.addSeparator();
        menu.add(setToolItem("","exit"));

        toolsMenu.add(setToolItem("images/pencil.png","pencil"));
        toolsMenu.add(setToolItem("images/line.png","line"));
        toolsMenu.add(setToolItem("images/quadrangle.png","quadrangle"));
        toolsMenu.add(setToolItem("images/circle.png","circle"));
        toolsMenu.add(setToolItem("images/eraser.png","eraser"));
        toolsMenu.add(setToolItem("images/magnifier.png","magnifier"));

        menuBar.add(menu);
        menuBar.add(toolsMenu);
    }

    public JMenuItem setToolItem(String iconName, String name) {
        JMenuItem item = new JMenuItem(new ImageIcon(iconName));
        item.setText(name);

        return item;
    }

    public void setTools(JPanel toolBar) {
        toolBar.add(setToolButton("images/pencil.png"), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(setToolButton("images/line.png"), new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(setToolButton("images/quadrangle.png"), new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(setToolButton("images/circle.png"), new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(setToolButton("images/eraser.png"), new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(setToolButton("images/magnifier.png"), new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    public JButton setToolButton(String iconName) {
        JButton button = new JButton(new ImageIcon(iconName));
        button.setBackground(Color.gray);
        button.setPreferredSize(new Dimension(32,32));

        return button;
    }
}