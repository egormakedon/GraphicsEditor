package cursors;

import java.awt.*;

public class Cursors {

    private Toolkit toolkit;

    private Image pencilCursorImage;
    private Cursor pencilCursor;

    private Image lineCursorImage;
    private Cursor lineCursor;

    private Image eraserCursorImage;
    private Cursor eraserCursor;

    public Cursors() {
        toolkit = Toolkit.getDefaultToolkit();

        pencilCursorImage = toolkit.getImage("images/pencil.png");
        pencilCursor = toolkit.createCustomCursor(pencilCursorImage, new Point(0,30), "pencilCursor");

        lineCursorImage = toolkit.getImage("images/line.png");
        lineCursor = toolkit.createCustomCursor(lineCursorImage, new Point(0,30), "lineCursor");

        eraserCursorImage = toolkit.getImage("images/eraser.png");
        eraserCursor = toolkit.createCustomCursor(eraserCursorImage, new Point(0,30), "eraserCursor");
    }

    public Cursor getPencilCursor() { return pencilCursor; }
    public Cursor getLineCursorCursor() { return lineCursor; }
    public Cursor getEraserCursor() { return eraserCursor; }
}