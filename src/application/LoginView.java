package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginView {

    private Scene scene;

    public LoginView() {
        GridPane gridPane = new GridPane();

        // Padding and Spacing
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Username label and text field
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);

        // Password label and password field
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        // Login button
        Button loginButton = new Button("Login");
        gridPane.add(loginButton, 1, 2);

        // Setting up the scene
        scene = new Scene(gridPane, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}

