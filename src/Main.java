public class Main {
    public static void main(String args[]) {
        Frame mainObj = new Frame();

        Instruments instruments = new Instruments();
        instruments.createInstruments(mainObj);

        mainObj.getFrame().setVisible(true);

        DrawPanel drawObj = new DrawPanel();
        drawObj.draw(mainObj, instruments);
    }
}