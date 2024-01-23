module co.edu.uniquindio.login {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.login to javafx.fxml;
    exports co.edu.uniquindio.login;
    exports co.edu.uniquindio.login.modelo.controllers;
    opens co.edu.uniquindio.login.modelo.controllers to javafx.fxml;
}