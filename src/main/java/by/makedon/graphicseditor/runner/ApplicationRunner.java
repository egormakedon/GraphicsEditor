package by.makedon.graphicseditor.runner;

import by.makedon.graphicseditor.window.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * @author Yahor Makedon
 */
public class ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> new Window().show());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
