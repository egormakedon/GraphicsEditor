package by.makedon.graphicseditor.runner;

import by.makedon.graphicseditor.window.Window;

import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }
}
