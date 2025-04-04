package mokhoase.whiteboard.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mokhoase.whiteboard.backend.DrawingManager;
import mokhoase.whiteboard.backend.MediaManager;

public class WhiteboardApp extends Application {
    private DrawingManager drawingManager;
    private MediaManager mediaManager;

    @Override
    public void start(Stage primaryStage) {
        drawingManager = new DrawingManager();
        mediaManager = new MediaManager();

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawingManager.setGraphicsContext(gc);

        BorderPane root = new BorderPane();
        root.setTop(ToolbarUI.createToolbar(drawingManager, mediaManager));
        root.setCenter(canvas);

        primaryStage.setTitle("Digital Whiteboard");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}