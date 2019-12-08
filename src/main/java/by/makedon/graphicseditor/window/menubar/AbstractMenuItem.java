package by.makedon.graphicseditor.window.menubar;

import by.makedon.graphicseditor.util.ResourceUtil;

import javax.swing.*;
import java.net.URL;

/**
 * @author Yahor Makedon
 */
public abstract class AbstractMenuItem extends JMenuItem {
    public AbstractMenuItem(String menuItemNamePropertyKey, String menuItemIconPathPropertyKey) {
        String menuItemName = ResourceUtil.getPropertyValue(menuItemNamePropertyKey);
        String menuItemIconPath = ResourceUtil.getPropertyValue(menuItemIconPathPropertyKey);

        setText(menuItemName);

        URL url = Thread.currentThread()
                        .getContextClassLoader()
                        .getResource(menuItemIconPath);
        if (url != null) {
            setIcon(new ImageIcon(url));
        }
    }
}
