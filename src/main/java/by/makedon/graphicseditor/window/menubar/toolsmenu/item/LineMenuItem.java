package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

import javax.swing.*;

/**
 * @author Yahor Makedon
 */
public class LineMenuItem extends AbstractMenuItem {
    public LineMenuItem(JMenu toolsMenu) {
        super(Constants.LINE_MENU_ITEM_NAME, Constants.LINE_MENU_ITEM_ICON_PATH);

        addActionListener((e) -> {
            setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.LINE_MENU_ITEM_NAME);
        });
    }

//    lineIt.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//Line line = new Line(drawManager);
//            drawManager.removeListeners();
//
//            drawPanel.addMouseListener(line.getMouseListener());
//            drawPanel.addMouseMotionListener(line.getMouseMotionListener());
//        }
//    });
}
