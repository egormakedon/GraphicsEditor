package by.makedon.graphicseditor.window.menubar.mainmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.util.ResourceUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Yahor Makedon
 */
public class OpenMenuItem extends JMenuItem {
    @SuppressWarnings("all")
    public OpenMenuItem() {
        String openMenuItemName = ResourceUtil.getPropertyValue(Constants.OPEN_MENU_ITEM_NAME);
        String openMenuItemIconPath = ResourceUtil.getPropertyValue(Constants.OPEN_MENU_ITEM_ICON_PATH);

        setText(openMenuItemName);
        setIcon(new ImageIcon(Thread.currentThread()
                                    .getContextClassLoader()
                                    .getResource(openMenuItemIconPath)));
    }

//    open.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JFileChooser fileChooser = new JFileChooser("D:\\");
//
//            int userSelection = fileChooser.showDialog(null,"Open");
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                File file = fileChooser.getSelectedFile();
//                try {
//                    BufferedImage img = ImageIO.read(file);
//
//                    drawPanel.setSize(new Dimension(img.getWidth(), img.getHeight()));
//                    drawPanel.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
//
//                    Graphics g = drawManager.getBufferedImage().getGraphics();
//                    g.drawImage(img,0, 0, drawPanel);
//                    drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//    });
}
