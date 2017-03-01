package run;

import draw.DrawPanel;
import frame.Frame;
import frame.Instruments;

public class Run {

    private Frame frameObj = new Frame();
    private Instruments instruments = new Instruments();
    private DrawPanel drawPanel = new DrawPanel();

    public void runFunction() {
        instruments.addInstrumentsFunction(frameObj);
        drawPanel.drawFunction(frameObj);
        frameObj.getFrame().setVisible(true);
    }
}