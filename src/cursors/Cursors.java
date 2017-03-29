package cursors;

import java.awt.*;

public class Cursors {

    private Toolkit toolkit;

    private Image pencilCursorImage;
    private Image lineCursorImage;
    private Image quadrangleCursorImage;
    private Image circleCursorImage;
    private Image eraserCursorImage;
    private Image magnifierCursorImage;

    private Cursor pencilCursor;
    private Cursor lineCursor;
    private Cursor quadrangleCursor;
    private Cursor circleCursor;
    private Cursor eraserCursor;
    private Cursor magnifierCursor;

    public Cursors() {
        toolkit = Toolkit.getDefaultToolkit();

        pencilCursorImage = toolkit.getImage("images/pencilCursor.png");
        lineCursorImage = toolkit.getImage("images/lineCursor.png");
        quadrangleCursorImage = toolkit.getImage("images/quadrangleCursor.png");
        circleCursorImage = toolkit.getImage("images/circleCursor.png");
        eraserCursorImage = toolkit.getImage("images/eraserCursor.png");
        magnifierCursorImage = toolkit.getImage("images/magnifierCursor.png");

        pencilCursor = toolkit.createCustomCursor(pencilCursorImage, new Point(0,30), "pencilCursor");
        lineCursor = toolkit.createCustomCursor(lineCursorImage, new Point(0,0), "lineCursor");
        quadrangleCursor = toolkit.createCustomCursor(quadrangleCursorImage, new Point(0,0), "quadrangleCursor");
        circleCursor = toolkit.createCustomCursor(circleCursorImage, new Point(0,0), "circleCursor");
        eraserCursor = toolkit.createCustomCursor(eraserCursorImage, new Point(5,30), "eraserCursor");
        magnifierCursor = toolkit.createCustomCursor(magnifierCursorImage, new Point(0,0), "magnifierCursor");
    }

    public Cursor getPencilCursor() { return pencilCursor; }
    public Cursor getLineCursor() { return lineCursor; }
    public Cursor getQuadrangleCursor() { return quadrangleCursor; }
    public Cursor getCircleCursor() { return circleCursor; }
    public Cursor getEraserCursor() { return eraserCursor; }
    public Cursor getMagnifierCursor() { return magnifierCursor; }
}