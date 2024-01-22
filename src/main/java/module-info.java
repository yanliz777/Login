module co.edu.uniquindio.login {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.login to javafx.fxml;
    exports co.edu.uniquindio.login;
}