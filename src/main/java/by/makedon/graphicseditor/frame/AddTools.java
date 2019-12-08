package by.makedon.graphicseditor.frame;

import by.makedon.graphicseditor.tools.*;
import by.makedon.graphicseditor.DrawManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddTools {
    private DrawManager drawManager = new DrawManager();
    private JPanel drawPanel;

    private JMenu menu = new JMenu("menu");
    private JMenu toolsMenu = new JMenu("tools");
    private JMenu colorMenu = new JMenu("color");
    private JColorChooser colorChooser = new JColorChooser();
    private JMenu thicknessMenu = new JMenu("thickness 1x");
    private JMenu selectionMenu = new JMenu("selection");

    public AddTools(JPanel drawPanel) {
        toolsMenu.setIcon(new ImageIcon("images/toolsMenu.png"));
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
        JMenuItem saveAs = setToolItem("","save as");
        JMenuItem clear = setToolItem("","clear");
        JMenuItem exit = setToolItem("","exit");

        JMenuItem pencil = setToolItem("images/pencil.png","pencil");
        JMenuItem line = setToolItem("images/line.png","line");
        JMenuItem quadrangle = setToolItem("images/quadrangle.png","quadrangle");
        JMenuItem circle = setToolItem("images/circle.png","circle");
        JMenuItem eraser = setToolItem("images/eraser.png","eraser");
        JMenuItem magnifier = setToolItem("images/magnifier.png","magnifier");
        JMenuItem text = setToolItem("images/text.png","text");

        JMenuItem thickness1x = setToolItem("","1x");
        JMenuItem thickness2x = setToolItem("","2x");
        JMenuItem thickness3x = setToolItem("","3x");

        JMenuItem selection1 = setToolItem("images/selection1.png", "rectangle");
        JMenuItem selection2 = setToolItem("images/selection2.png", "arbitrary");

        menu.add(saveAs);
        menu.addSeparator();
        menu.add(clear);
        menu.addSeparator();
        menu.add(exit);

        toolsMenu.add(pencil);
        toolsMenu.add(line);
        toolsMenu.add(quadrangle);
        toolsMenu.add(circle);
        toolsMenu.add(eraser);
        toolsMenu.add(magnifier);
        toolsMenu.add(text);

        colorMenu.add(colorChooser);

        thicknessMenu.add(thickness1x);
        thicknessMenu.add(thickness2x);
        thicknessMenu.add(thickness3x);

        selectionMenu.add(selection1);
        selectionMenu.add(selection2);

        menuBar.add(menu);
        menuBar.add(toolsMenu);
        menuBar.add(colorMenu);
        menuBar.add(thicknessMenu);
        menuBar.add(selectionMenu);

        setMenuFunction(saveAs, clear, exit, thickness1x, thickness2x, thickness3x);
        setItemFunction(pencil, line, quadrangle, eraser, circle, text, selection1, selection2, magnifier);
    }

    public void setItemFunction(JMenuItem pencilIt, JMenuItem lineIt, JMenuItem quadrangleIt
            , JMenuItem eraserIt, JMenuItem circleIt, JMenuItem textIt,
                                JMenuItem selection1, JMenuItem selection2, JMenuItem magnifierIt) {

        drawManager.setDrawManager(drawPanel, colorChooser);

        Pencil pencil = new Pencil(drawManager);
        Line line = new Line(drawManager);
        Quadrangle quadrangle = new Quadrangle(drawManager);
        Eraser eraser = new Eraser(drawManager);
        Circle circle = new Circle(drawManager);
        Text text = new Text(drawManager);
        Selection selection = new Selection(drawManager);
        Magnifier magnifier = new Magnifier(drawManager);

        pencilIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(pencil.getMouseListener());
                drawPanel.addMouseMotionListener(pencil.getMouseMotionListener());
            }
        });

        lineIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(line.getMouseListener());
                drawPanel.addMouseMotionListener(line.getMouseMotionListener());
            }
        });

        quadrangleIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(quadrangle.getMouseListener());
                drawPanel.addMouseMotionListener(quadrangle.getMouseMotionListener());
            }
        });

        circleIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(circle.getMouseListener());
                drawPanel.addMouseMotionListener(circle.getMouseMotionListener());
            }
        });

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

    public void setMenuFunction(JMenuItem saveAs,
                                JMenuItem clear, JMenuItem exit, JMenuItem thickness1x,
                                JMenuItem thickness2x, JMenuItem thickness3x) {

        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("D:\\");

                int userSelection = fileChooser.showDialog(null,"Save as");
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String file = fileChooser.getSelectedFile().getAbsolutePath() + ".png";
                    try {
                        ImageIO.write(drawManager.getBufferedImage(),"png", new File(file));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Graphics g = drawManager.getBufferedImage().getGraphics();
                g.fillRect(0,0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
                drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(), 0, 0, drawPanel);
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
