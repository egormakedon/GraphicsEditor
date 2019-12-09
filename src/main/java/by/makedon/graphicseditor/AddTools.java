package by.makedon.graphicseditor;

import by.makedon.graphicseditor.tools.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTools {
    private DrawManager drawManager = new DrawManager();
    private JPanel drawPanel;

    private JMenu toolsMenu = new JMenu("tools");
    private JMenu colorMenu = new JMenu("color");
    private JColorChooser colorChooser = new JColorChooser();
    private JMenu thicknessMenu = new JMenu("thickness 1x");
    private JMenu selectionMenu = new JMenu("selection");

    public AddTools(JPanel drawPanel) {
        colorMenu.setIcon(new ImageIcon("images/colorMenu.png"));
        thicknessMenu.setIcon(new ImageIcon("images/thicknessMenu.png"));
        selectionMenu.setIcon(new ImageIcon("images/selection1.png"));

        colorMenu.setForeground(Color.black);
        colorChooser.setColor(Color.black);

        this.drawPanel = drawPanel;
    }

    public void setBars (JMenuBar menuBar) {
        setMenuTools(menuBar);
    }

    public void setMenuTools(JMenuBar menuBar) {
        JMenuItem eraser = setToolItem("images/eraser.png","eraser");
        JMenuItem magnifier = setToolItem("images/magnifier.png","magnifier");
        JMenuItem text = setToolItem("images/text.png","text");

        JMenuItem thickness1x = setToolItem("","1x");
        JMenuItem thickness2x = setToolItem("","2x");
        JMenuItem thickness3x = setToolItem("","3x");

        JMenuItem selection1 = setToolItem("images/selection1.png", "rectangle");
        JMenuItem selection2 = setToolItem("images/selection2.png", "arbitrary");

        toolsMenu.add(eraser);
        toolsMenu.add(magnifier);
        toolsMenu.add(text);

        colorMenu.add(colorChooser);

        thicknessMenu.add(thickness1x);
        thicknessMenu.add(thickness2x);
        thicknessMenu.add(thickness3x);

        selectionMenu.add(selection1);
        selectionMenu.add(selection2);

        menuBar.add(toolsMenu);
        menuBar.add(colorMenu);
        menuBar.add(thicknessMenu);
        menuBar.add(selectionMenu);

        setMenuFunction(thickness1x, thickness2x, thickness3x);
        setItemFunction(eraser, text, selection1, selection2, magnifier);
    }

    public void setItemFunction(JMenuItem eraserIt, JMenuItem textIt,
                                JMenuItem selection1, JMenuItem selection2, JMenuItem magnifierIt) {

        drawManager.setDrawManager(drawPanel, colorChooser);

        Eraser eraser = new Eraser(drawManager);

        Text text = new Text(drawManager);
        Selection selection = new Selection(drawManager);
        Magnifier magnifier = new Magnifier(drawManager);


        eraserIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(eraser.getMouseListener());
                drawPanel.addMouseMotionListener(eraser.getMouseMotionListener());
            }
        });

        magnifierIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(magnifier.getMouseListener());
                drawPanel.addMouseMotionListener(magnifier.getMouseMotionListener());
            }
        });

        textIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(text.getMouseListener());
                drawPanel.addMouseMotionListener(text.getMouseMotionListener());
            }
        });

        selection1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(selection.getMouseListener1());
                drawPanel.addMouseMotionListener(selection.getMouseMotionListener1());
            }
        });

        selection2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(selection.getMouseListener2());
                drawPanel.addMouseMotionListener(selection.getMouseMotionListener2());
            }
        });
    }

    public JMenuItem setToolItem(String iconName, String name) {
        JMenuItem item = new JMenuItem(new ImageIcon(iconName));
        item.setText(name);

        return item;
    }

    public void setMenuFunction(JMenuItem thickness1x,
                                JMenuItem thickness2x, JMenuItem thickness3x) {




        colorMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                colorMenu.setForeground(colorChooser.getColor());
            }
        });

        thickness1x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setThickness(1);
                thicknessMenu.setText("thickness 1x");
            }
        });

        thickness2x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setThickness(2);
                thicknessMenu.setText("thickness 2x");
            }
        });

        thickness3x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.setThickness(3);
                thicknessMenu.setText("thickness 3x");
            }
        });
    }

    public DrawManager getDrawManager() { return drawManager; }
}