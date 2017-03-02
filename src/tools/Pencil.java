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

        PencilActionListener pencilActionListener = new PencilActionListener();
        PencilMouseMotionListener pencilMouseMotionListener = new PencilMouseMotionListener();

        pencilButton.addActionListener(pencilActionListener);
        pencilButton.addMouseMotionListener(pencilMouseMotionListener);





        pencilButton.addActionListener(new ActionListener() {
            boolean isPressed = false;
            int x1, y1;

            @Override
            public void actionPerformed(ActionEvent e) {

                frameObj.getDrawPanel().setCursor(frameObj.getCursors().getPencilCursor());

                frameObj.getDrawPanel().addMouseMotionListener(new MouseMotionListener() {

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        Point location = frameObj.getDrawPanel().getMousePosition();


                        if (!isPressed) {
                            x1 = (int) location.getX();
                            y1 = (int) location.getY();
                        }

                        isPressed = true;
                        paint(e, frameObj, x1, y1, location);

                        x1 = (int) location.getX();
                        y1 = (int) location.getY();
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {

                    }
                });
            }
        });
    }

    public void paint(MouseEvent e, Frame frameObj, int x1, int y1, Point location) {

        int x2, y2;

        x2 = (int) location.getX();
        y2 = (int) location.getY();

        frameObj.getDrawPanel().getGraphics().drawLine(x1, y1, x2, y2);
    }

    class PencilMouseMotionListener implements MouseMotionListener {

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }
    }

    class PencilActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public JButton getPencilButton() { return pencilButton; }
    public JMenuItem getPencilMenuItem() { return pencilMenuItem; }
}
