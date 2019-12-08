package by.makedon.graphicseditor.window.menubar.mainmenu;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenu;
import by.makedon.graphicseditor.window.menubar.mainmenu.item.ClearMenuItem;
import by.makedon.graphicseditor.window.menubar.mainmenu.item.ExitMenuItem;
import by.makedon.graphicseditor.window.menubar.mainmenu.item.OpenMenuItem;
import by.makedon.graphicseditor.window.menubar.mainmenu.item.SaveAsMenuItem;

/**
 * @author Yahor Makedon
 */
public class MainMenu extends AbstractMenu {
    public MainMenu() {
        super(Constants.MAIN_MENU_NAME, Constants.MAIN_MENU_ICON_PATH);

        add(new OpenMenuItem());
        add(new SaveAsMenuItem());
        addSeparator();
        add(new ClearMenuItem());
        addSeparator();
        add(new ExitMenuItem());
    }
}
