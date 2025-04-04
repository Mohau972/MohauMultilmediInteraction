module mokhoase.ass1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens mokhoase.ass1 to javafx.fxml;
    exports mokhoase.ass1;
    exports mokhoase.whiteboard.frontend;
    opens mokhoase.whiteboard.frontend to javafx.fxml;
    exports mokhoase.whiteboard.backend;
    opens mokhoase.whiteboard.backend to javafx.fxml;
}