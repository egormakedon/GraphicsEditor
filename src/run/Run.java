package run;

import frame.Frame;
import frame.Instruments;

public class Run {

    private Frame frameObj = new Frame();
    private Instruments instruments = new Instruments();

    public void runFunction() {
        instruments.addInstrumentsFunction(frameObj);
        frameObj.getFrame().setVisible(true);
    }
}