package tools;

import frame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pencil {

    private JButton pencilButton = new JButton();
    private JMenuItem pencilMenuItem = new JMenuItem("pencil");

    public Pencil() {
        pencilButton.setBackground(Color.gray);
        pencilButton.setPreferredSize(new Dimension(32,32));
        pencilButton.setIcon(new ImageIcon("images/pencil.png"));

        pencilMenuItem.setIcon(new ImageIcon("images/pencil.png"));
    }

    public void pencilFunction(Frame frameObj) {
        pencilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameObj.getDrawPanel().setCursor(frameObj.getCursors().getPencilCursor());
                   frameObj.getDrawPanel().addMouseMotionListener(new MouseMotionListener() {
                       int x1 = -1, y1;

                       public void mouseDragged(MouseEvent e) {
                           int x2, y2;

                           Point location = frameObj.getDrawPanel().getMousePosition();
                           x2 = (int) location.getX();
                           y2 = (int) location.getY();

                           if (x1 == -1) {
                                x1 = x2;
                                y1 = y2;
                           }

                           frameObj.getDrawPanel().getGraphics().drawLine(x2, y2, x2, y2);

                           x1 = x2;
                           y1 = y2;
                       }

                       @Override
                       public void mouseMoved(MouseEvent e) {

                       }
                   });

                   frameObj.getDrawPanel().addMouseListener(new MouseListener() {

                       public void mouseClicked(MouseEvent e) {
                           Point location = frameObj.getDrawPanel().getMousePosition();

                           int x = (int) location.getX();
                           int y = (int) location.getY();

                           frameObj.getDrawPanel().getGraphics().drawLine(x, y, x, y);
                       }

                       @Override
                       public void mousePressed(MouseEvent e) {

                       }

                       @Override
                       public void mouseReleased(MouseEvent e) {

                       }

                       @Override
                       public void mouseEntered(MouseEvent e) {

                       }

                       @Override
                       public void mouseExited(MouseEvent e) {

                       }
                   });
            }
        });
    }

    public JButton getPencilButton() { return pencilButton; }
    public JMenuItem getPencilMenuItem() { return pencilMenuItem; }
}