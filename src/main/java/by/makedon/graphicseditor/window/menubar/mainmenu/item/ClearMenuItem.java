package by.makedon.graphicseditor.window.menubar.mainmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

/**
 * @author Yahor Makedon
 */
public class ClearMenuItem extends AbstractMenuItem {
    public ClearMenuItem() {
        super(Constants.CLEAR_MENU_ITEM_NAME, Constants.CLEAR_MENU_ITEM_ICON_PATH);
    }

//    clear.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            Graphics g = drawManager.getBufferedImage().getGraphics();
//            g.fillRect(0,0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
//            drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(), 0, 0, drawPanel);
//        }
//    });
}
