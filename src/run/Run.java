package run;

import draw.DrawPanel;
import frame.Frame;

public class Run {

    private Frame frameObj = new Frame();
    private DrawPanel drawPanel = new DrawPanel();

    public void runFunction() {
        frameObj.addInstrumentsFunction(frameObj);
        drawPanel.drawFunction(frameObj);
        frameObj.getFrame().setVisible(true);
    }
}