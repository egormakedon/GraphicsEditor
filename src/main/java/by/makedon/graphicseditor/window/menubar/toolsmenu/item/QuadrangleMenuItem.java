package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

import javax.swing.*;

/**
 * @author Yahor Makedon
 */
public class QuadrangleMenuItem extends AbstractMenuItem {
    public QuadrangleMenuItem(JMenu toolsMenu) {
        super(Constants.QUADRANGLE_MENU_ITEM_NAME, Constants.QUADRANGLE_MENU_ITEM_ICON_PATH);

        addActionListener((e) -> {
            setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.QUADRANGLE_MENU_ITEM_NAME);
        });
    }

//    quadrangleIt.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Quadrangle quadrangle = new Quadrangle(drawManager);
//            drawManager.removeListeners();
//
//            drawPanel.addMouseListener(quadrangle.getMouseListener());
//            drawPanel.addMouseMotionListener(quadrangle.getMouseMotionListener());
//        }
//    });
}
