package by.makedon.graphicseditor.window.menubar.thicknessmenu;

import by.makedon.graphicseditor.manager.DrawManager;
import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.util.ResourceUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public class ThicknessMenu extends JSlider {
    public ThicknessMenu() {
        int thicknessMenuWidth = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.THICKNESS_MENU_WIDTH));
        int thicknessMenuHeight = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.THICKNESS_MENU_HEIGHT));
        Dimension dimension = new Dimension(thicknessMenuWidth, thicknessMenuHeight);

        int thicknessMinValue = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.THICKNESS_MIN_VALUE));
        int thicknessMaxValue = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.THICKNESS_MAX_VALUE));
        int thicknessValue = Integer.parseInt(ResourceUtil.getPropertyValue(Constants.THICKNESS_VALUE));

        String thicknessMenuBackgroundColor = ResourceUtil.getPropertyValue(Constants.THICKNESS_MENU_BACKGROUND_COLOR);
        String thicknessMenuBForegroundColor = ResourceUtil.getPropertyValue(Constants.THICKNESS_MENU_FOREGROUND_COLOR);

        setSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);

        setMinimum(thicknessMinValue);
        setMaximum(thicknessMaxValue);
        setValue(thicknessValue);

        setBackground(Color.getColor(thicknessMenuBackgroundColor));
        setForeground(Color.getColor(thicknessMenuBForegroundColor));

        setPaintTicks(true);
        setMinorTickSpacing(1);

        addChangeListener((e) -> DrawManager.getInstance().setThickness(getValue()));
    }
}
