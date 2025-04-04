package mokhoase.whiteboard.backend;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;

import java.util.Stack;

public class UndoRedoManager {
    private final Stack<WritableImage> undoStack = new Stack<>();
    private final Stack<WritableImage> redoStack = new Stack<>();
    private final GraphicsContext gc;

    public UndoRedoManager(GraphicsContext gc) {
        this.gc = gc;
    }

    public void saveState() {
        WritableImage snapshot = gc.getCanvas().snapshot(new SnapshotParameters(), null);
        undoStack.push(snapshot);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            WritableImage current = gc.getCanvas().snapshot(new SnapshotParameters(), null);
            redoStack.push(current);
            WritableImage previous = undoStack.pop();
            gc.drawImage(previous, 0, 0);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            WritableImage next = redoStack.pop();
            undoStack.push(gc.getCanvas().snapshot(new SnapshotParameters(), null));
            gc.drawImage(next, 0, 0);
        }
    }
}
