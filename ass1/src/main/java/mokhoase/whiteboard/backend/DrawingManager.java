package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.*;

public class DrawingManager {
    private GraphicsContext gc;
    private final List<DrawableItem> items = new ArrayList<>();
    private final Deque<DrawableItem> redoStack = new LinkedList<>();
    private Color currentColor = Color.BLACK;

    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
    }

    public void setDrawingMode(Color color) {
        this.currentColor = color;
        gc.setStroke(currentColor); // Set the current drawing color
    }

    public void drawPath(DrawingPath path) {
        path.draw(gc);
        items.add(path);
        redoStack.clear();
    }

    public void undo() {
        if (!items.isEmpty()) {
            DrawableItem item = items.remove(items.size() - 1);
            redoStack.push(item);
            redraw();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            DrawableItem item = redoStack.pop();
            items.add(item);
            redraw();
        }
    }

    public void clear() {
        items.clear();
        redoStack.clear();
        gc.clearRect(0, 0, 800, 600);
    }

    public void addText(String text, double x, double y) {
        DrawableText drawableText = new DrawableText(text, x, y);
        items.add(drawableText);
        redraw();
    }

    public void addImage(String path, double x, double y) {
        Image img = new Image(path);
        DrawableImage drawableImage = new DrawableImage(img, x, y);
        items.add(drawableImage);
        redraw();
    }

    public void addVideo(String path) {
        items.add(new DrawableVideo(path));
        redraw();
    }

    public void addMusic(String path) {
        items.add(new DrawableMusic(path));
        redraw();
    }

    private void redraw() {
        gc.clearRect(0, 0, 800, 600);
        for (DrawableItem item : items) {
            item.draw(gc);
        }
    }
}