package by.makedon.graphicseditor.window.menubar.thicknessmenu;

import by.makedon.graphicseditor.manager.DrawManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yahor Makedon
 */
public class ThicknessMenu extends JSlider {
    public ThicknessMenu() {
        //TODO
        super(1, 8, 2);
        setPaintTicks(true);
        setPreferredSize(new Dimension(200, 35));
        setSize(new Dimension(200, 35));
        setMaximumSize(new Dimension(200, 35));
        setMinorTickSpacing(1);
        setBackground(Color.getColor("#C0C0C0"));
        setForeground(Color.BLACK);
        //TODO

        addChangeListener((e) -> {
            DrawManager.getInstance().setThickness(getValue());
        });
    }
}
