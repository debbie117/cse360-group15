package application;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class DoctorView {

    private Scene scene;

    public DoctorView() {
        VBox layout = new VBox();
        // TODO: add UI components to layout

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
