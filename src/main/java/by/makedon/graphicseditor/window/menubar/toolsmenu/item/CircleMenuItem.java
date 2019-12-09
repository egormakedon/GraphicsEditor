package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

import javax.swing.*;

/**
 * @author Yahor Makedon
 */
public class CircleMenuItem extends AbstractMenuItem {
    public CircleMenuItem(JMenu toolsMenu) {
        super(Constants.CIRCLE_MENU_ITEM_NAME, Constants.CIRCLE_MENU_ITEM_ICON_PATH);

        addActionListener((e) -> {
            setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.CIRCLE_MENU_ITEM_NAME);
        });
    }

//    circleIt.addActionListener(new ActionListener() {
//        Circle circle = new Circle(drawManager);
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            drawManager.removeListeners();
//
//            drawPanel.addMouseListener(circle.getMouseListener());
//            drawPanel.addMouseMotionListener(circle.getMouseMotionListener());
//        }
//    });
}
