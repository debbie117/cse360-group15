package application;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.control.;
import javafx.scene.layout.;
import javafx.stage.Stage;

private Patient currentPatient;


public class PatientPortalView {

    private Scene scene;

    public PatientPortalView() {
        VBox layout = new VBox();
        // TODO: add UI components to layout

        scene = new Scene(layout, 300, 200);
    }

@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Heart Health Imaging and Recording System");

    // Main View
    VBox mainLayout = new VBox();
    Label titleLabel = new Label("Welcome to Heart Health Imaging and Recording System");
    Button patientIntakeButton = new Button("Patient Intake");
    Button ctScanTechButton = new Button("CT Scan Tech View");
    Button patientViewButton = new Button("Patient View");

    mainLayout.getChildren().addAll(titleLabel, patientIntakeButton, ctScanTechButton, patientViewButton);

    // Patient Intake View
    VBox patientIntakeLayout = new VBox();
    Label patientIntakeLabel = new Label("Patient Intake Form");
    Label firstNameLabel = new Label("First Name:");
    TextField firstNameField = new TextField();
    Label lastNameLabel = new Label("Last Name:");
    TextField lastNameField = new TextField();
    Label dobLabel = new Label("Date of Birth:");
    TextField dobField = new TextField();

    Button saveButton = new Button("Save");
    saveButton.setOnAction(event -> {
        // Save patient information and create patient file
        String patientID = generatePatientID();
        savePatientInformation(patientID, firstNameField.getText(), lastNameField.getText(), dobField.getText());
        // Create a new Patient object
        currentPatient = new Patient(patientID, firstNameField.getText(), lastNameField.getText(), dobField.getText());
        // Clear the form fields
        firstNameField.clear();
        lastNameField.clear();
        dobField.clear();
        // Show success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Patient information saved successfully!");
        alert.showAndWait();
    });

    patientIntakeLayout.getChildren().addAll(patientIntakeLabel, firstNameLabel, firstNameField,
            lastNameLabel, lastNameField, dobLabel, dobField, saveButton);

    // CT Scan Tech View
    VBox ctScanTechLayout = new VBox();
    Label ctScanTechLabel = new Label("CT Scan Tech View");
    // ... Add CT scan tech UI components

    // Patient View
    VBox patientViewLayout = new VBox();
    Label patientViewLabel = new Label("Patient View");
    Label helloLabel = new Label("Hello");
    Label patientNameLabel = new Label();
    Label totalAgatstonLabel = new Label("Total Agatston CAC score:");
    Label lmLabel = new Label("LM:");
    Label ladLabel = new Label("LAD:");
    Label lcxLabel = new Label("LCX:");
    Label rcaLabel = new Label("RCA:");
    Label pdaLabel = new Label("PDA:");

    Button viewDataButton = new Button("View Data");
    viewDataButton.setOnAction(event -> {
        // Show patient data in the view
        if (currentPatient != null) {
            patientNameLabel.setText(currentPatient.getFirstName() + " " + currentPatient.getLastName());
            // Retrieve and display CT scan data
            String ctScanData = retrieveCTScanData(currentPatient.getId());
            if (ctScanData != null) {
                String[] ctScanDataArray = ctScanData.split(",");
                totalAgatstonScoreField.setText(ctScanDataArray[0]);
                lmField.setText(ctScanDataArray[1]);
                ladField.setText(ctScanDataArray[2]);
                lcxField.setText(ctScanDataArray[3]);
                rcaField.setText(ctScanDataArray[4]);
                pdaField.setText(ctScanDataArray[5]);
            } else {
                totalAgatstonScoreField.setText("");
                lmField.setText("");
                ladField.setText("");
                lcxField.setText("");
                rcaField.setText("");
                pdaField.setText("");
            }
        } else {
            // No patient selected, show error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No patient selected. Please enter a valid patient ID.");
            alert.showAndWait();
        }
    });

    patientViewLayout.getChildren().addAll(patientViewLabel, helloLabel, patientNameLabel,
            totalAgatstonLabel, totalAgatstonScoreField, lmLabel, lmField, ladLabel, ladField,
            lcxLabel, lcxField, rcaLabel, rcaField, pdaLabel, pdaField, viewDataButton);

    // Set actions for buttons
    patientIntakeButton.setOnAction(event -> primaryStage.setScene(new Scene(patientIntakeLayout, 300, 200)));
    ctScanTechButton.setOnAction(event -> primaryStage.setScene(new Scene(ctScanTechLayout, 300, 200)));
    patientViewButton.setOnAction(event -> primaryStage.setScene(new Scene(patientViewLayout, 300, 200)));

    // Create the main scene
    Scene mainScene = new Scene(mainLayout, 300, 200);
    primaryStage.setScene(mainScene);
    primaryStage.show();
}

private String generatePatientID() {
    // Generate a unique 5-digit patient ID (you can implement your own logic here)
    return "12345";
}

private void savePatientInformation(String patientID, String firstName, String lastName, String dob) {
    // Save patient information to file (you can implement your own logic here)
    // For simplicity, we are just printing the data
    System.out.println("Patient ID: " + patientID);
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Date of Birth: " + dob);
}

private String retrieveCTScanData(String patientID) {
    // Retrieve CT scan data from file based on patient ID (you can implement your own logic here)
    // For simplicity, we are just returning sample data
    if (patientID.equals("12345")) {
        return "100,10,20,30,40,50";
    } else {
        return null;
    }
}

    public Scene getScene() {
        return scene;
    }
}

