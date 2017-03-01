package draw;

import frame.Instruments;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanel {
    public void draw(frame.Frame mainObj, Instruments instruments) {

        mainObj.getDrawPanel().addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                //if (mainObj.getDrawPanel().getCursor() == instruments.getCursors().getPencilCursor()) {

                    Point location = mainObj.getDrawPanel().getMousePosition();

                    int x = (int) location.getX();
                    int y = (int) location.getY() + 30;

                    mainObj.getDrawPanel().getGraphics().drawLine(x, y, x, y);
                    mainObj.getDrawPanel().getGraphics().drawLine(x-1, y+1, x-1, y+1);
                    mainObj.getDrawPanel().getGraphics().drawLine(x, y+1, x, y+1);
                    mainObj.getDrawPanel().getGraphics().drawLine(x+1, y+1, x+1, y+1);
                    mainObj.getDrawPanel().getGraphics().drawLine(x-1, y, x-1, y);
                    mainObj.getDrawPanel().getGraphics().drawLine(x+1, y, x+1, y);
                    mainObj.getDrawPanel().getGraphics().drawLine(x-1, y-1, x-1, y-1);
                    mainObj.getDrawPanel().getGraphics().drawLine(x, y-1, x, y-1);
                    mainObj.getDrawPanel().getGraphics().drawLine(x+1, y-1, x+1, y-1);
               // }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        mainObj.getDrawPanel().addMouseListener(new MouseListener() {
            int x;
            int y;

            @Override
            public void mouseClicked(MouseEvent e) {

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
}