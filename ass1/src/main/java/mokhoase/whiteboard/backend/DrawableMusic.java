package mokhoase.whiteboard.backend;

import javafx.scene.canvas.GraphicsContext;

public class DrawableMusic implements DrawableItem {
    private final String musicPath;

    public DrawableMusic(String path) {
        this.musicPath = path;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillText("Music: " + musicPath, 150, 150);
    }
}