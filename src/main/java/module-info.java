module com.example.trabalhopratico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.trabalhopratico to javafx.fxml;
    exports com.example.trabalhopratico;
}