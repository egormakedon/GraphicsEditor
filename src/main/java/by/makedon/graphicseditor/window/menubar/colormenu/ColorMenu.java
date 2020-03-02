package by.makedon.graphicseditor.window.menubar.colormenu;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenu;

import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public class ColorMenu extends AbstractMenu {
    public ColorMenu() {
        super(Constants.COLOR_MENU_NAME, Constants.COLOR_MENU_ICON_PATH);
        setForeground(Color.BLACK);
        add(new JColorChooser(new ColorSelectionModel(this)));
    }

    private static final class ColorSelectionModel extends DefaultColorSelectionModel {
        private ColorSelectionModel(JMenu colorMenu) {
            super(Color.BLACK);

            addChangeListener((e) -> {
                Color selectedColor = getSelectedColor();
                if (!colorMenu.getForeground().equals(selectedColor)) {
                    colorMenu.setForeground(selectedColor);
                    DrawManager.getInstance().setColor(selectedColor);
                }
            });
        }
    }
}
