package frame;

import tools.Eraser;
import tools.Pencil;
import window.DrawManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class AddTools {

    private DrawManager drawManager = new DrawManager();
    private JPanel drawPanel;

    private JMenu menu = new JMenu("menu");
    private JMenu toolsMenu = new JMenu("tools");
    private JMenu colorMenu = new JMenu("color");
    private JColorChooser colorChooser = new JColorChooser();

    public AddTools(JPanel drawPanel) {
        menu.setIcon(new ImageIcon("images/menu.png"));
        toolsMenu.setIcon(new ImageIcon("images/toolsMenu.png"));
        colorMenu.setIcon(new ImageIcon("images/colorMenu.png"));
        colorMenu.setForeground(Color.black);
        colorChooser.setColor(Color.black);

        this.drawPanel = drawPanel;
    }

    public void setBars (JMenuBar menuBar, JPanel toolBar) {
        setMenuTools(menuBar);
        setTools(toolBar);
    }

    public void setMenuTools(JMenuBar menuBar) {
        JMenuItem open = setToolItem("","open");
        JMenuItem saveAs = setToolItem("","save as");
        JMenuItem exit = setToolItem("","exit");

        JMenuItem pencil = setToolItem("images/pencil.png","pencil");
        JMenuItem line = setToolItem("images/line.png","line");
        JMenuItem quadrangle = setToolItem("images/quadrangle.png","quadrangle");
        JMenuItem circle = setToolItem("images/circle.png","circle");
        JMenuItem eraser = setToolItem("images/eraser.png","eraser");
        JMenuItem magnifier = setToolItem("images/magnifier.png","magnifier");

        menu.add(open);
        menu.add(saveAs);
        menu.addSeparator();
        menu.add(exit);

        toolsMenu.add(pencil);
        toolsMenu.add(line);
        toolsMenu.add(quadrangle);
        toolsMenu.add(circle);
        toolsMenu.add(eraser);
        toolsMenu.add(magnifier);

        colorMenu.add(colorChooser);

        menuBar.add(menu);
        menuBar.add(toolsMenu);
        menuBar.add(colorMenu);

        setItemFunction(pencil, eraser, open, saveAs, exit);
    }

    public JMenuItem setToolItem(String iconName, String name) {
        JMenuItem item = new JMenuItem(new ImageIcon(iconName));
        item.setText(name);

        return item;
    }

    public void setItemFunction(JMenuItem pencil, JMenuItem eraser, JMenuItem open, JMenuItem saveAs, JMenuItem exit) {

        pencil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setDrawManager(drawPanel, colorChooser);
                Pencil pencil = new Pencil(drawManager);
                pencil.setFunction();
            }
        });

        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setDrawManager(drawPanel, colorChooser);
                Eraser eraser = new Eraser(drawManager);
                eraser.setFunction();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        colorMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                colorMenu.setForeground(colorChooser.getColor());
            }
        });
    }

    public void setTools(JPanel toolBar) {
        JButton pencil = setToolButton("images/pencil.png");
        JButton line = setToolButton("images/line.png");
        JButton quadrangle = setToolButton("images/quadrangle.png");
        JButton circle = setToolButton("images/circle.png");
        JButton eraser = setToolButton("images/eraser.png");
        JButton magnifier = setToolButton("images/magnifier.png");

        toolBar.add(pencil, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(line, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(quadrangle, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(circle, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(eraser, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        toolBar.add(magnifier, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        setButtonFunction(pencil, line, quadrangle, circle, eraser, magnifier);
    }

    public JButton setToolButton(String iconName) {
        JButton button = new JButton(new ImageIcon(iconName));
        button.setBackground(Color.gray);
        button.setPreferredSize(new Dimension(32,32));

        return button;
    }

    public void setButtonFunction(JButton pencil, JButton line,
                                  JButton quadrangle, JButton circle,
                                  JButton eraser, JButton magnifier) {

        pencil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setDrawManager(drawPanel, colorChooser);
                Pencil pencil = new Pencil(drawManager);
                pencil.setFunction();
            }
        });

        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setDrawManager(drawPanel, colorChooser);
                Eraser eraser = new Eraser(drawManager);
                eraser.setFunction();
            }
        });
    }
}