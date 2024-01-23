package co.edu.uniquindio.login.modelo.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {

    @FXML
    private Button BtnRegistrarUsuario;

    @FXML
    private TextField txtUserIngresar;

    @FXML
    private PasswordField txtPasswordIngresar;

    @FXML
    private Button btnIngresarUsuario;

    @FXML
    private CheckBox cbxMostrarPassword;

    @FXML
    void btnIngresarUsuario(ActionEvent event) {

    }

    @FXML
    void BtnRegistrarUsuario(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
