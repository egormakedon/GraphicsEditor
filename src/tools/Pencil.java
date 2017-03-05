package tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Pencil {

    private JButton pencilButton = new JButton();
    private JMenuItem pencilMenuItem = new JMenuItem("pencil");

    public Pencil() {
        pencilButton.setBackground(Color.gray);
        pencilButton.setPreferredSize(new Dimension(32,32));
        pencilButton.setIcon(new ImageIcon("images/pencil.png"));

        pencilMenuItem.setIcon(new ImageIcon("images/pencil.png"));
    }

    public void pencilFunction(JPanel drawPanel, Cursor cursor, JColorChooser colorChooser, JMenu colorChooserMenu) {
        pencilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setCursor(cursor);

                drawPanel.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        Point location = drawPanel.getMousePosition();
                        int x = (int) location.getX();
                        int y = (int) location.getY();

                        Image img = createBufferedImage(colorChooser.getColor(), colorChooserMenu);
                        drawPanel.getGraphics().drawImage(img,x,y,drawPanel);
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {

                    }
                });
            }
        });
    }

    public Image createBufferedImage(Color color, JMenu menu) {
        BufferedImage bufferedImage = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.setColor(color);
        menu.setForeground(color);
        g.drawLine(0,0,0,0);

        return bufferedImage;
    }

    public JButton getPencilButton() { return pencilButton; }
    public JMenuItem getPencilMenuItem() { return pencilMenuItem; }
}