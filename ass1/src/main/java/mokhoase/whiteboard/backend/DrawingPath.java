
// === BACKEND: DrawingPath.java ===
package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;

public class DrawingPath implements DrawableItem {
    private final List<Point> points;

    public DrawingPath(List<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
    }
}
