module com.example.rockpaperscissors {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.rockpaperscissors to javafx.fxml;
    exports com.example.rockpaperscissors;
}