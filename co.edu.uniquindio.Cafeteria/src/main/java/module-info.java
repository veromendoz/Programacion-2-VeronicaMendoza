module co.edu.uniquindio.cafeteria.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.cafeteria.cafeteria to javafx.fxml;
    exports co.edu.uniquindio.cafeteria.cafeteria;
    exports co.edu.uniquindio.cafeteria.cafeteria.model;
    opens co.edu.uniquindio.cafeteria.cafeteria.model to javafx.fxml;
    exports co.edu.uniquindio.cafeteria.cafeteria.ViewController;
    opens co.edu.uniquindio.cafeteria.cafeteria.ViewController to javafx.fxml;
    exports co.edu.uniquindio.cafeteria.cafeteria.Controller;
    opens co.edu.uniquindio.cafeteria.cafeteria.Controller to javafx.fxml;
    exports co.edu.uniquindio.cafeteria.cafeteria.Services;
    opens co.edu.uniquindio.cafeteria.cafeteria.Services to javafx.fxml;
}