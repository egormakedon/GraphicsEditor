package frame;

import tools.Eraser;
import tools.Pencil;
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

    public AddTools(JPanel drawPanel) {
        menu.setIcon(new ImageIcon("images/menu.png"));
        toolsMenu.setIcon(new ImageIcon("images/toolsMenu.png"));
        colorMenu.setIcon(new ImageIcon("images/colorMenu.png"));
        thicknessMenu.setIcon(new ImageIcon("images/thicknessMenu.png"));

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

        menuBar.add(menu);
        menuBar.add(toolsMenu);
        menuBar.add(colorMenu);
        menuBar.add(thicknessMenu);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("D:\\");

                int userSelection = fileChooser.showDialog(null,"Open");
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedImage img = ImageIO.read(file);
                        drawPanel.getGraphics().drawImage(img,0,0, drawPanel);
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
                drawManager.getBufferedImage().getGraphics().fillRect(0,0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
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

        setItemFunction(pencil, eraser);
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

        setButtonFunction(pencil, eraser);
    }

    public void setItemFunction(JMenuItem pencil, JMenuItem eraser) {

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    public void setButtonFunction(JButton pencil, JButton eraser) {

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
}