import cursors.Cursors;
import instruments.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruments {

    private Pencil pencil = new Pencil();
    private Line line = new Line();
    private Quadrangle quadrangle = new Quadrangle();
    private Circle circle = new Circle();
    private Eraser eraser = new Eraser();

    private Cursors cursors = new Cursors();

    public void createInstruments( Frame mainObj ) {

        mainObj.getToolBar().add(pencil.getPencilButton(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        mainObj.getToolBar().add(line.getLineButton(), new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        mainObj.getToolBar().add(quadrangle.getQuadrangleButton(), new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        mainObj.getToolBar().add(circle.getCircleButton(), new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));
        mainObj.getToolBar().add(eraser.getEraserButton(), new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 5, 0, 6), 0, 0));

        mainObj.getMenuBar().add(mainObj.getMenu());

        mainObj.getFrame().setJMenuBar(mainObj.getMenuBar());
        mainObj.getFrame().add(mainObj.getToolBar(), BorderLayout.WEST);
        mainObj.getFrame().add(mainObj.getDrawPanel(), BorderLayout.CENTER);

        mainObj.getFrame().setCursor(cursors.getMainCursor());

        pencil.getPencilButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainObj.getDrawPanel().setCursor(cursors.getPencilCursor());
            }
        });

        line.getLineButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainObj.getDrawPanel().setCursor(cursors.getLineCursorCursor());
            }
        });
    }

    public Pencil getPencil() { return pencil; }
    public Line getLine() { return line; }
    public Quadrangle getQuadrangle() { return quadrangle; }
    public Circle getCircle() { return circle; }
    public Eraser getEraser() { return eraser; }

    public Cursors getCursors() { return cursors; }
}