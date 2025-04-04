package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawableLine implements DrawableItem {
    private final double startX, startY, endX, endY;
    private final Color color;

    public DrawableLine(double startX, double startY, double endX, double endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeLine(startX, startY, endX, endY);
    }
}