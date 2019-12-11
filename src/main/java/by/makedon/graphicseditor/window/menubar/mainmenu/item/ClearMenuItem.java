package by.makedon.graphicseditor.window.menubar.mainmenu.item;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

/**
 * @author Yahor Makedon
 */
public class ClearMenuItem extends AbstractMenuItem {
    public ClearMenuItem() {
        super(Constants.CLEAR_MENU_ITEM_NAME, Constants.CLEAR_MENU_ITEM_ICON_PATH);
        addActionListener((e) -> DrawManager.getInstance().clearDrawPanel());
    }
}
