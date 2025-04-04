package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;

public class DrawableVideo implements DrawableItem {
    private final String videoPath;

    public DrawableVideo(String path) {
        this.videoPath = path;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillText("Video: " + videoPath, 100, 100);
    }
}