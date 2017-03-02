package frame;

import javax.swing.*;
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
        frameObj.getToolBar().add(frameObj.getMagnifier().getMagnifierButton(), new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));

        JMenu toolsMenu = frameObj.getToolsMenu();
        toolsMenu.add(frameObj.getPencil().getPencilMenuItem());
        toolsMenu.add(frameObj.getLine().getLineMenuItem());
        toolsMenu.add(frameObj.getQuadrangle().getQuadrangleMenuItem());
        toolsMenu.add(frameObj.getCircle().getCircleMenuItem());
        toolsMenu.add(frameObj.getEraser().getEraserMenuItem());
        toolsMenu.add(frameObj.getMagnifier().getMagnifierMenuItem());

        frameObj.getMenuBar().add(frameObj.getMenu());
        frameObj.getMenuBar().add(toolsMenu);
        frameObj.getMenuBar().add(frameObj.getColorPanel().getColorPanel());

        frameObj.getFrame().setJMenuBar(frameObj.getMenuBar());

        frameObj.getFrame().add(frameObj.getToolBar(), BorderLayout.WEST);
        frameObj.getFrame().add(frameObj.getDrawPanel(), BorderLayout.CENTER);
    }
}