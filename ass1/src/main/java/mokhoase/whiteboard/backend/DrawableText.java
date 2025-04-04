package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;

public class DrawableText implements DrawableItem {
    private final String text;
    private final double x, y;

    public DrawableText(String text, double x, double y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillText(text, x, y);
    }
}