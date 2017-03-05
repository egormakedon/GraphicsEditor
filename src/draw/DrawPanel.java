package draw;

import frame.Frame;
import tools.Pencil;

public class DrawPanel {
    public void drawFunction(Frame frameObj) {
        Pencil pencil = frameObj.getPencil();
        pencil.pencilFunction(frameObj.getDrawPanel());
    }
}