package com.practice;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label label;


    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnlogout;

    @FXML
    private ChoiceBox<String> choicebox = new ChoiceBox<>();

    @FXML
    private ComboBox<String> combobox = new ComboBox<>();


    @FXML
    void onnext(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("combo_box.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage = new Stage();
        stage.setTitle("Combo_Page");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage n_login = (Stage) btnlogout.getScene().getWindow();
        n_login.close();
        stage.show();
    }

    @FXML
    void onclick(ActionEvent event) {
        label.setText("Welcome to dropdown test!");
        System.out.println(combobox.getSelectionModel().getSelectedItem());
        System.out.println(choicebox.getSelectionModel().getSelectedItem());
        System.out.println("selection completed.");
    }

    @FXML
    void onlogout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage s_logout = (Stage) btnlogout.getScene().getWindow();
        s_logout.close();
        stage.show();

    }


    @FXML
    void oncancel(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onlogin(ActionEvent event) throws IOException {
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        if (username.getText().equals("jaye") && password.getText().equals(" ")) {
            message.setContentText("Successfully logged in");
            message.setTitle("LOGIN SUCCESSFUL!");
            message.show();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nextpage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            Stage stage = new Stage();
            stage.setTitle("second_page");
            stage.setScene(scene);
            stage.setResizable(false);
            Stage s_login = (Stage) btnlogin.getScene().getWindow();
            s_login.close();
            stage.show();

        }
        else {
            message.setContentText("Invalid login details");
            message.setTitle("LOGIN UNSUCCESSFUL!");
            message.show();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combobox.getItems().addAll("Select Programme", "CE", "IS", "MN");
        combobox.getSelectionModel().select(0);

        choicebox.getItems().addAll("Select Hall", "Grace Star", "CH", "KT");
        choicebox.getSelectionModel().select(0);
    }
}
