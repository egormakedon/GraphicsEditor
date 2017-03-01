import javax.swing.*;
import java.awt.*;

public class Frame {

    private JFrame frame = new JFrame("Graphics Editor");
    private JPanel drawPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu();
    private JPanel toolBar = new JPanel();

    public Frame() {
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        drawPanel.setBackground(Color.white);

        menuBar.setBackground(Color.gray);
        menuBar.setPreferredSize(new Dimension(0,30));

        menu.setIcon(new ImageIcon("images/menu.png"));

        toolBar.setBackground(Color.gray);
        toolBar.setLayout(new GridBagLayout());
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getDrawPanel() { return drawPanel; }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenu getMenu() {
        return menu;
    }

    public JPanel getToolBar() {
        return toolBar;
    }
}