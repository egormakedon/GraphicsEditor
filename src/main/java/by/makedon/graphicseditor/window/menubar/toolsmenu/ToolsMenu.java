package by.makedon.graphicseditor.window.menubar.toolsmenu;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.util.ResourceUtil;
import by.makedon.graphicseditor.window.menubar.AbstractMenu;
import by.makedon.graphicseditor.window.menubar.toolsmenu.item.CircleMenuItem;
import by.makedon.graphicseditor.window.menubar.toolsmenu.item.LineMenuItem;
import by.makedon.graphicseditor.window.menubar.toolsmenu.item.PencilMenuItem;
import by.makedon.graphicseditor.window.menubar.toolsmenu.item.QuadrangleMenuItem;

/**
 * @author Yahor Makedon
 */
public class ToolsMenu extends AbstractMenu {
    public ToolsMenu() {
        super(Constants.TOOLS_MENU_NAME, Constants.TOOLS_MENU_ICON_PATH);

        setText(String.format("%s: %s",
                getText(),
                ResourceUtil.getPropertyValue(Constants.PENCIL_MENU_ITEM_NAME)));

        add(new PencilMenuItem(this));
        add(new LineMenuItem(this));
        add(new QuadrangleMenuItem(this));
        add(new CircleMenuItem(this));
    }
}
