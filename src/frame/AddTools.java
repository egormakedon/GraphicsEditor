package frame;

import tools.*;
import window.DrawManager;

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
        menu.setIcon(new ImageIcon("images/menu.png"));
        toolsMenu.setIcon(new ImageIcon("images/toolsMenu.png"));
        colorMenu.setIcon(new ImageIcon("images/colorMenu.png"));
        thicknessMenu.setIcon(new ImageIcon("images/thicknessMenu.png"));
        selectionMenu.setIcon(new ImageIcon("images/selection1.png"));

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

        menu.add(open);
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

        setMenuFunction(open, saveAs, clear, exit, thickness1x, thickness2x, thickness3x);
        setItemFunction(pencil, line, quadrangle, eraser, circle, text, selection1, selection2);
    }

    public void setTools(JPanel toolBar) {
        JButton pencil = setToolButton("images/pencil.png");
        JButton line = setToolButton("images/line.png");
        JButton quadrangle = setToolButton("images/quadrangle.png");
        JButton circle = setToolButton("images/circle.png");
        JButton eraser = setToolButton("images/eraser.png");
        JButton magnifier = setToolButton("images/magnifier.png");
        JButton text = setToolButton("images/text.png");

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
        toolBar.add(text, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        setButtonFunction(pencil, line, quadrangle, eraser, circle, text);
    }

    public void setItemFunction(JMenuItem pencilIt, JMenuItem lineIt, JMenuItem quadrangleIt
            , JMenuItem eraserIt, JMenuItem circleIt, JMenuItem textIt, JMenuItem selection1, JMenuItem selection2) {

        drawManager.setDrawManager(drawPanel, colorChooser);

        Pencil pencil = new Pencil(drawManager);
        Line line = new Line(drawManager);
        Quadrangle quadrangle = new Quadrangle(drawManager);
        Eraser eraser = new Eraser(drawManager);
        Circle circle = new Circle(drawManager);
        Text text = new Text(drawManager);

        Selection selection = new Selection(drawManager);

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

    public void setButtonFunction(JButton pencilBut, JButton lineBut
            , JButton quadrangleBut, JButton eraserBut, JButton circleBut, JButton textBut) {

        drawManager.setDrawManager(drawPanel, colorChooser);

        Pencil pencil = new Pencil(drawManager);
        Line line = new Line(drawManager);
        Quadrangle quadrangle = new Quadrangle(drawManager);
        Eraser eraser = new Eraser(drawManager);
        Circle circle = new Circle(drawManager);
        Text text = new Text(drawManager);

        drawPanel.addMouseListener(pencil.getMouseListener());
        drawPanel.addMouseMotionListener(pencil.getMouseMotionListener());

        pencilBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(pencil.getMouseListener());
                drawPanel.addMouseMotionListener(pencil.getMouseMotionListener());
            }
        });

        lineBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(line.getMouseListener());
                drawPanel.addMouseMotionListener(line.getMouseMotionListener());
            }
        });

        quadrangleBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(quadrangle.getMouseListener());
                drawPanel.addMouseMotionListener(quadrangle.getMouseMotionListener());
            }
        });

        circleBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(circle.getMouseListener());
                drawPanel.addMouseMotionListener(circle.getMouseMotionListener());
            }
        });

        eraserBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(eraser.getMouseListener());
                drawPanel.addMouseMotionListener(eraser.getMouseMotionListener());
            }
        });

        textBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawManager.removeListeners();

                drawPanel.addMouseListener(text.getMouseListener());
                drawPanel.addMouseMotionListener(text.getMouseMotionListener());
            }
        });
    }

    public JMenuItem setToolItem(String iconName, String name) {
        JMenuItem item = new JMenuItem(new ImageIcon(iconName));
        item.setText(name);

        return item;
    }

    public JButton setToolButton(String iconName) {
        JButton button = new JButton(new ImageIcon(iconName));
        button.setBackground(Color.gray);
        button.setPreferredSize(new Dimension(32,32));

        return button;
    }

    public void setMenuFunction(JMenuItem open, JMenuItem saveAs,
                                JMenuItem clear, JMenuItem exit, JMenuItem thickness1x,
                                JMenuItem thickness2x, JMenuItem thickness3x) {

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("D:\\");

                int userSelection = fileChooser.showDialog(null,"Open");
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedImage img = ImageIO.read(file);
                        Graphics g = drawManager.getBufferedImage().getGraphics();
                        g.drawImage(img,0, 0, drawPanel);
                        drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

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