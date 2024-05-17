package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String enteredEmail = emailField.getText();
        String enteredPassword = passwordField.getText();
        String correctEmail = "student@usthb.com"; // Change this to your actual correct email
        String correctPassword = "usthb"; // Change this to your actual correct password

        if (enteredEmail.equals(correctEmail) && enteredPassword.equals(correctPassword)) {
            // Email and password are correct, switch to Scene02
            switchToScene2(event);
        } else {
            // Incorrect email or password, display an error message or take appropriate action
            showAlert("Error", "Incorrect email or password. Please try again.");
        }
    }

 public void switchToScene2(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("scene02.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 public void switchToScene1(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("scene01.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
 private void showAlert(String title, String message) {
     Alert alert = new Alert(AlertType.ERROR);
     alert.setTitle(title);
     alert.setHeaderText(null);
     alert.setContentText(message);
     alert.showAndWait();
 }
}