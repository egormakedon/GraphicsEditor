package frame;

import tools.*;

import javax.swing.*;
import java.awt.*;

public class Frame implements AddInstruments {

    private JPanel drawPanel = new JPanel();

    private JFrame frame = new JFrame("Graphics Editor");
    private JMenuBar menuBar = new JMenuBar();
    private JPanel toolBar = new JPanel();

    private JMenu menu = new JMenu("menu");
    private JMenu toolsMenu = new JMenu("tools");

    private Pencil pencil = new Pencil();
    private Line line = new Line();
    private Quadrangle quadrangle = new Quadrangle();
    private Circle circle = new Circle();
    private Eraser eraser = new Eraser();
    private Magnifier magnifier = new Magnifier();

    public Frame() {

        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        menuBar.setBackground(Color.gray);
        menuBar.setPreferredSize(new Dimension(0, 30));
        menuBar.setBorder(BorderFactory.createEtchedBorder());

        toolBar.setBackground(Color.gray);
        toolBar.setLayout(new GridBagLayout());
        toolBar.setBorder(BorderFactory.createEtchedBorder());

        menu.setIcon(new ImageIcon("images/menu.png"));
        toolsMenu.setIcon(new ImageIcon("images/toolsMenu.png"));
    }

    public JFrame getFrame() { return frame; }
    public JPanel getToolBar() { return toolBar; }
    public JMenuBar getMenuBar() { return menuBar; }
    public JMenu getMenu() { return menu; }
    public JMenu getToolsMenu() { return toolsMenu; }
    public Pencil getPencil() { return pencil; }
    public Line getLine() { return line; }
    public Quadrangle getQuadrangle() { return quadrangle; }
    public Circle getCircle() { return circle; }
    public Eraser getEraser() { return eraser; }
    public Magnifier getMagnifier() { return magnifier; }
    public JPanel getDrawPanel() { return drawPanel; }
}