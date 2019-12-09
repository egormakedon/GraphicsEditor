package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

import javax.swing.*;

/**
 * @author Yahor Makedon
 */
public class PencilMenuItem extends AbstractMenuItem {
    public PencilMenuItem(JMenu toolsMenu) {
        super(Constants.PENCIL_MENU_ITEM_NAME, Constants.PENCIL_MENU_ITEM_ICON_PATH);

        addActionListener((e) -> {
            setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.PENCIL_MENU_ITEM_NAME);
        });
    }

//    pencilIt.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Pencil pencil = new Pencil(drawManager);
//            drawManager.removeListeners();
//
//            drawPanel.addMouseListener(pencil.getMouseListener());
//            drawPanel.addMouseMotionListener(pencil.getMouseMotionListener());
//        }
//    });
}
