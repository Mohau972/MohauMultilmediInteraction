package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DrawableImage implements DrawableItem {
    private final Image image;
    private final double x, y;

    public DrawableImage(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }
}