package by.makedon.graphicseditor.window.menubar.mainmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

/**
 * @author Yahor Makedon
 */
public class ExitMenuItem extends AbstractMenuItem {
    public ExitMenuItem() {
        super(Constants.EXIT_MENU_ITEM_NAME, Constants.EXIT_MENU_ITEM_ICON_PATH);
    }

//    exit.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.exit(1);
//        }
//    });
}
