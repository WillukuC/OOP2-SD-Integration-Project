module com.example.oop2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop2 to javafx.fxml;
    exports com.example.oop2;
    exports com.example.oop2.Controllers;
    opens com.example.oop2.Controllers to javafx.fxml;
}