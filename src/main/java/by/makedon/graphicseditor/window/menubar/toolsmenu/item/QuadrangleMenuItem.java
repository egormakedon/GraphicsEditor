package by.makedon.graphicseditor.window.menubar.toolsmenu.item;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.tool.impl.Quadrangle;
import by.makedon.graphicseditor.tool.ToolManager;
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
            if (!(DrawManager.getInstance().getTool() instanceof Quadrangle)) {
                setMenuName(toolsMenu, Constants.TOOLS_MENU_NAME, Constants.QUADRANGLE_MENU_ITEM_NAME);
                DrawManager.getInstance()
                           .setTool(ToolManager.getInstance()
                                               .getTool(Quadrangle.class));
            }
        });
    }
}
