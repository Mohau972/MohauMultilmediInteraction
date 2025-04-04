package mokhoase.whiteboard.frontend;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;
import mokhoase.whiteboard.backend.DrawingManager;
import mokhoase.whiteboard.backend.MediaManager;

public class ToolbarUI {
    public static ToolBar createToolbar(DrawingManager drawingManager, MediaManager mediaManager) {
        Button drawBtn = new Button("Draw");
        Button undoBtn = new Button("Undo");
        Button redoBtn = new Button("Redo");
        Button clearBtn = new Button("Clear");
        Button textBtn = new Button("Text");
        Button addImgBtn = new Button("Add Image");
        Button addVidBtn = new Button("Add Video");
        Button addMusicBtn = new Button("Add Music");
        ColorPicker colorPicker = new ColorPicker();

        drawBtn.setOnAction(e -> drawingManager.setDrawingMode(colorPicker.getValue()));
        undoBtn.setOnAction(e -> drawingManager.undo());
        redoBtn.setOnAction(e -> drawingManager.redo());
        clearBtn.setOnAction(e -> drawingManager.clear());
        textBtn.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("Hello");
            dialog.setTitle("Input Text");
            dialog.setHeaderText("Enter text to draw:");
            dialog.showAndWait().ifPresent(text -> drawingManager.addText(text, 100, 100));
        });

        addImgBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            var file = fileChooser.showOpenDialog(null);
            if (file != null) {
                drawingManager.addImage(file.toURI().toString(), 200, 200);
            }
        });

        addVidBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi"));
            var file = fileChooser.showOpenDialog(null);
            if (file != null) {
                drawingManager.addVideo(file.toURI().toString());
            }
        });

        addMusicBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav"));
            var file = fileChooser.showOpenDialog(null);
            if (file != null) {
                drawingManager.addMusic(file.toURI().toString());
            }
        });

        return new ToolBar(drawBtn, undoBtn, redoBtn, clearBtn, textBtn, addImgBtn, addVidBtn, addMusicBtn, colorPicker);
    }
}