package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.impl.Line;
import by.makedon.graphicseditor.tool.ToolManager;
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
            if (!(DrawManager.getInstance().getTool() instanceof Line)) {
                setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.LINE_MENU_ITEM_NAME);
                DrawManager.getInstance()
                           .setTool(ToolManager.getInstance()
                                               .getTool(Line.class));
            }
        });
    }
}
