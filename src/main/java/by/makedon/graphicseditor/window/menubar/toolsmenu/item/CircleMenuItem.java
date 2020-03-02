package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.impl.Circle;
import by.makedon.graphicseditor.tool.ToolManager;
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
            if (!(DrawManager.getInstance().getTool() instanceof Circle)) {
                setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.CIRCLE_MENU_ITEM_NAME);
                DrawManager.getInstance()
                           .setTool(ToolManager.getInstance()
                                               .getTool(Circle.class));
            }
        });
    }
}
