module com.practice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.practice to javafx.fxml;
    exports com.practice;
}