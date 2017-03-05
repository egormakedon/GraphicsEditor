package draw;

import cursors.Cursors;
import frame.Frame;
import tools.Pencil;

import javax.swing.*;

public class DrawPanel {
    public void drawFunction(Frame frameObj) {
        Pencil pencil = frameObj.getPencil();
        Cursors cursors = frameObj.getCursors();
        JPanel drawPanel = frameObj.getDrawPanel();
        JMenu colorChooserMenu = frameObj.getColorChooserMenu();
        JColorChooser colorChooser = frameObj.getColorChooser();

        pencil.pencilFunction(drawPanel, cursors.getPencilCursor(), colorChooser, colorChooserMenu);
    }
}