package frame;

import java.awt.*;

public class Instruments {
    public void addInstrumentsFunction(Frame frameObj) {

        frameObj.getToolBar().add(frameObj.getPencil().getPencilButton(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        frameObj.getToolBar().add(frameObj.getLine().getLineButton(), new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        frameObj.getToolBar().add(frameObj.getQuadrangle().getQuadrangleButton(), new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        frameObj.getToolBar().add(frameObj.getCircle().getCircleButton(), new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        frameObj.getToolBar().add(frameObj.getEraser().getEraserButton(), new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));

        frameObj.getToolsMenu().add(frameObj.getPencil().getPencilMenuItem());
        frameObj.getToolsMenu().add(frameObj.getLine().getLineMenuItem());
        frameObj.getToolsMenu().add(frameObj.getQuadrangle().getQuadrangleMenuItem());
        frameObj.getToolsMenu().add(frameObj.getCircle().getCircleMenuItem());
        frameObj.getToolsMenu().add(frameObj.getEraser().getEraserMenuItem());

        frameObj.getMenuBar().add(frameObj.getMenu());
        frameObj.getMenuBar().add(frameObj.getToolsMenu());
        frameObj.getMenuBar().add(frameObj.getColorPanel().getColorPanel());

        frameObj.getFrame().setJMenuBar(frameObj.getMenuBar());

        frameObj.getFrame().add(frameObj.getToolBar(), BorderLayout.WEST);
        frameObj.getFrame().add(frameObj.getDrawPanel(), BorderLayout.CENTER);
    }
}