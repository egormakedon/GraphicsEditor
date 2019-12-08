package by.makedon.graphicseditor.window.menubar.mainmenu;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.util.ResourceUtil;
import by.makedon.graphicseditor.window.menubar.mainmenu.item.OpenMenuItem;

import javax.swing.*;

/**
 * @author Yahor Makedon
 */
public class MainMenu extends JMenu {
    @SuppressWarnings("all")
    public MainMenu() {
        String mainMenuName = ResourceUtil.getPropertyValue(Constants.MAIN_MENU_NAME);
        String mainMenuIconPath = ResourceUtil.getPropertyValue(Constants.MAIN_MENU_ICON_PATH);

        setText(mainMenuName);
        setIcon(new ImageIcon(Thread.currentThread()
                                    .getContextClassLoader()
                                    .getResource(mainMenuIconPath)));

        add(new OpenMenuItem());
    }
}
