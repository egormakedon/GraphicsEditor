package by.makedon.graphicseditor;

import by.makedon.graphicseditor.DrawManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Selection {

    private Cursor cursor;
    private JPanel drawPanel;

    private boolean isPressed = false;
    private int x1, x2, y1, y2, x3, y3;
    private int MouseX, MouseY;
    private BufferedImage transparentBufImg;
    private BufferedImage copyBufImg;
    private DrawManager drawManager;

    private ArrayList arrayListForX;
    private ArrayList arrayListForY;
    private Polygon polygon;
    private BufferedImage buf;

    public Selection(DrawManager drawManager) {
        cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        drawPanel = drawManager.getDrawPanel();

        this.drawManager = drawManager;
    }

    private MouseMotionListener mouseMotionListener1 = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (!isPressed) {
                x1 = e.getX();
                y1 = e.getY();
            }

            isPressed = true;
            x2 = e.getX();
            y2 = e.getY();

            paint1();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            MouseX = e.getX();
            MouseY = e.getY();
            drawPanel.setCursor(cursor);
        }
    };

    private MouseListener mouseListener1 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            transparentBufImg = new BufferedImage((int) screenSize.getWidth(), (int) screenSize.getHeight(), BufferedImage.TYPE_INT_RGB);

            drawPanel.removeKeyListener(copyListener);
            drawPanel.removeKeyListener(pasteListener);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drawPanel.requestFocus();
            drawPanel.addKeyListener(copyListener);
            drawPanel.addKeyListener(pasteListener);

            isPressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            drawPanel.removeKeyListener(copyListener);
            drawPanel.removeKeyListener(pasteListener);
        }
    };

    private MouseMotionListener mouseMotionListener2 = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (!isPressed) {
                x3 = x1 = e.getX();
                y3 = y1 = e.getY();
            }

            isPressed = true;
            x2 = e.getX();
            y2 = e.getY();

            arrayListForX.add(x2);
            arrayListForY.add(y2);

            paint2();

            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            MouseX = e.getX();
            MouseY = e.getY();
            drawPanel.setCursor(cursor);
        }
    };

    private MouseListener mouseListener2 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            transparentBufImg = new BufferedImage((int) screenSize.getWidth(), (int) screenSize.getHeight(), BufferedImage.TYPE_INT_RGB);
            transparentBufImg.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);

            arrayListForX = new ArrayList();
            arrayListForY = new ArrayList();
            polygon = new Polygon();

            drawPanel.removeKeyListener(copyListenerSecond);
            drawPanel.removeKeyListener(pasteListenerSecond);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Graphics2D g = (Graphics2D) transparentBufImg.getGraphics();
            g.setColor(Color.cyan);
            g.setStroke(new BasicStroke(1.0f));
            g.drawLine(x1, y1, x3, y3);
            drawPanel.getGraphics().drawImage(transparentBufImg, 0, 0, drawPanel);

            drawPanel.requestFocus();
            drawPanel.addKeyListener(copyListenerSecond);
            drawPanel.addKeyListener(pasteListenerSecond);

            isPressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            drawPanel.setCursor(cursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            drawPanel.removeKeyListener(copyListenerSecond);
            drawPanel.removeKeyListener(pasteListenerSecond);
        }
    };

    public void paint1() {
        transparentBufImg.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);

        Graphics2D g = (Graphics2D) transparentBufImg.getGraphics();

        g.setColor(Color.cyan);
        g.setStroke(new BasicStroke(1.0f));

        if (x1 < x2 && y1 < y2) g.drawRect(x1, y1, x2 - x1, y2 - y1);
        if (x1 < x2 && y1 > y2) g.drawRect(x1, y2, x2 - x1, y1 - y2);
        if (x1 > x2 && y1 > y2) g.drawRect(x2, y2, x1 - x2, y1 - y2);
        if (x1 > x2 && y1 < y2) g.drawRect(x2, y1, x1 - x2, y2 - y1);

        drawPanel.getGraphics().drawImage(transparentBufImg,0,0, drawPanel);
    }

    public void paint2() {
        Graphics2D g = (Graphics2D) transparentBufImg.getGraphics();

        g.setColor(Color.cyan);
        g.setStroke(new BasicStroke(1.0f));

        if (isPressed) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            g.drawLine(x1, y1, x1, y1);
        }

        drawPanel.getGraphics().drawImage(transparentBufImg, 0, 0, drawPanel);
    }

    private KeyListener copyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                if (x1 < x2 && y1 < y2)
                {
                    copyBufImg = new BufferedImage(x2 - x1,y2 - y1, BufferedImage.TYPE_INT_RGB);
                    copyBufImg.getGraphics().drawImage(drawManager.getBufferedImage().getSubimage(x1, y1, x2 - x1, y2 - y1),0,0, drawPanel);
                }

                if (x1 < x2 && y1 > y2) {
                    copyBufImg = new BufferedImage(x2 - x1,y1 - y2, BufferedImage.TYPE_INT_RGB);
                    copyBufImg.getGraphics().drawImage(drawManager.getBufferedImage().getSubimage(x1, y2, x2 - x1, y1 - y2),0,0, drawPanel);
                }

                if (x1 > x2 && y1 > y2) {
                    copyBufImg = new BufferedImage(x1 - x2,y1 - y2, BufferedImage.TYPE_INT_RGB);
                    copyBufImg.getGraphics().drawImage(drawManager.getBufferedImage().getSubimage(x2, y2, x1 - x2, y1 - y2),0,0, drawPanel);
                }

                if (x1 > x2 && y1 < y2) {
                    copyBufImg = new BufferedImage(x1 - x2,y2 - y1, BufferedImage.TYPE_INT_RGB);
                    copyBufImg.getGraphics().drawImage(drawManager.getBufferedImage().getSubimage(x2, y1, x1 - x2, y2 - y1),0,0, drawPanel);
                }
            }
        }
    };

    private KeyListener copyListenerSecond = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                Object[] arrX = arrayListForX.toArray();
                Object[] arrY = arrayListForY.toArray();

                for (int i = 0; i < arrX.length; i++) {
                    polygon.addPoint( ((Integer)arrX[i]).intValue(), ((Integer)arrY[i]).intValue());
                }

                Rectangle r = polygon.getBounds();
                buf = new BufferedImage((int) r.getWidth(), (int) r.getHeight(), BufferedImage.TYPE_INT_RGB);
                buf.getGraphics().drawImage(drawManager.getBufferedImage().getSubimage((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight()),0,0, drawPanel);
            }
        }
    };

    private KeyListener pasteListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                drawManager.getBufferedImage().getGraphics().drawImage(copyBufImg, MouseX, MouseY, drawPanel);
                drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
            }
        }
    };

    private KeyListener pasteListenerSecond = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                Graphics2D g = (Graphics2D) buf.getGraphics();
                Rectangle r = polygon.getBounds();

                for (int x = (int) r.getX(); x <= (int)(r.getX() + r.getWidth()); x++) {
                    for (int y = (int) r.getY(); y <= (int)(r.getY() + r.getHeight()); y++) {
                        if (!polygon.contains(x, y)) {
                            if (MouseX + x - (int) r.getX() < drawManager.getBufferedImage().getWidth() && MouseY + y - (int) r.getY() < drawManager.getBufferedImage().getHeight()) {
                                g.setColor(new Color(drawManager.getBufferedImage().getRGB(MouseX + x - (int) r.getX(), MouseY + y - (int) r.getY())));
                            }
                            g.drawLine(x - (int) r.getX(),y - (int) r.getY(),x - (int) r.getX(),y - (int) r.getY());
                        }
                    }
                }

                drawManager.getBufferedImage().getGraphics().drawImage(buf, MouseX, MouseY, drawPanel);
                drawPanel.getGraphics().drawImage(drawManager.getBufferedImage(),0,0, drawPanel);
            }
        }
    };

    public MouseMotionListener getMouseMotionListener1() { return mouseMotionListener1; }
    public MouseListener getMouseListener1() { return mouseListener1; }

    public MouseMotionListener getMouseMotionListener2() { return mouseMotionListener2; }
    public MouseListener getMouseListener2() { return mouseListener2; }
}
