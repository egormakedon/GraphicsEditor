package by.makedon.graphicseditor.window.menubar.mainmenu.item;

import by.makedon.graphicseditor.util.Constants;
import by.makedon.graphicseditor.window.menubar.AbstractMenuItem;

/**
 * @author Yahor Makedon
 */
public class SaveAsMenuItem extends AbstractMenuItem {
    public SaveAsMenuItem() {
        super(Constants.SAVE_AS_MENU_ITEM_NAME, Constants.SAVE_AS_MENU_ITEM_ICON_PATH);
    }

//    saveAs.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JFileChooser fileChooser = new JFileChooser("D:\\");
//
//            int userSelection = fileChooser.showDialog(null,"Save as");
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                String file = fileChooser.getSelectedFile().getAbsolutePath() + ".png";
//                try {
//                    ImageIO.write(drawManager.getBufferedImage(),"png", new File(file));
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//    });
}
