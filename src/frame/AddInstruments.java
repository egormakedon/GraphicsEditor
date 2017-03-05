package frame;

import tools.*;

import javax.swing.*;
import java.awt.*;

public interface AddInstruments {
     default void addInstrumentsFunction(Frame frameObj) {

        JPanel toolBar = frameObj.getToolBar();
        JMenu toolsMenu = frameObj.getToolsMenu();
        JFrame frame = frameObj.getFrame();
        JMenuBar menuBar = frameObj.getMenuBar();
        JMenu menu = frameObj.getMenu();
        JPanel drawPanel = frameObj.getDrawPanel();

        Pencil pencil = frameObj.getPencil();
        Line line = frameObj.getLine();
        Quadrangle quadrangle = frameObj.getQuadrangle();
        Circle circle = frameObj.getCircle();
        Eraser eraser = frameObj.getEraser();
        Magnifier magnifier = frameObj.getMagnifier();

        toolBar.add(pencil.getPencilButton(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        toolBar.add(line.getLineButton(), new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        toolBar.add(quadrangle.getQuadrangleButton(), new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        toolBar.add(circle.getCircleButton(), new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        toolBar.add(eraser.getEraserButton(), new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        toolBar.add(magnifier.getMagnifierButton(), new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));

        toolsMenu.add(pencil.getPencilMenuItem());
        toolsMenu.add(line.getLineMenuItem());
        toolsMenu.add(quadrangle.getQuadrangleMenuItem());
        toolsMenu.add(circle.getCircleMenuItem());
        toolsMenu.add(eraser.getEraserMenuItem());
        toolsMenu.add(magnifier.getMagnifierMenuItem());

        menuBar.add(menu);
        menuBar.add(toolsMenu);

        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.WEST);
        frame.add(drawPanel);
    }
}