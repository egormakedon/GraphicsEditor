package by.makedon.graphicseditor.window.menubar;

import by.makedon.graphicseditor.util.ResourceUtil;

import javax.swing.*;
import java.net.URL;

/**
 * @author Yahor Makedon
 */
public abstract class AbstractMenu extends JMenu {
    public AbstractMenu(String menuNamePropertyKey, String menuIconPathPropertyKey) {
        String menuName = ResourceUtil.getPropertyValue(menuNamePropertyKey);
        String menuIconPath = ResourceUtil.getPropertyValue(menuIconPathPropertyKey);

        setText(menuName);

        URL url = Thread.currentThread()
                        .getContextClassLoader()
                        .getResource(menuIconPath);
        if (url != null) {
            setIcon(new ImageIcon(url));
        }
    }
}
