package by.makedon.graphicseditor.window.menubar.mainmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

/**
 * @author Yahor Makedon
 */
public class OpenMenuItem extends AbstractMenuItem {
    public OpenMenuItem() {
        super(Constants.OPEN_MENU_ITEM_NAME, Constants.OPEN_MENU_ITEM_ICON_PATH);
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
