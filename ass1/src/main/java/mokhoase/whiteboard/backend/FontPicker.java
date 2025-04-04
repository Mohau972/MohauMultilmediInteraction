
// === BACKEND: FontPicker.java ===
package mokhoase.whiteboard.backend;

import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;

public class FontPicker extends ComboBox<String> {
    public FontPicker() {
        this.getItems().addAll(Font.getFamilies());
        this.setValue("Arial");
    }

    public Font getSelectedFont(double size) {
        return new Font(this.getValue(), size);
    }
}