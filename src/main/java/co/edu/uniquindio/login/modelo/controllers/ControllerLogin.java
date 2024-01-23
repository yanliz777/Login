package co.edu.uniquindio.login.modelo.controllers;
import co.edu.uniquindio.login.HelloApplication;
import co.edu.uniquindio.login.modelo.logic.UsuarioLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {

    ControllerRegitrarUsuario controllerRegitrarUsuario = new ControllerRegitrarUsuario();
    ControllerPginaPrincipal controllerPginaPrincipal = new ControllerPginaPrincipal();
    HelloApplication ventana = new HelloApplication();
    @FXML
    private Button BtnRegistrarUsuario;

    @FXML
    private TextField txtUserIngresar;

    @FXML
    private TextField txtPasswordIngresar;

    @FXML
    private Button btnIngresarUsuario;

    private void mostrarMensaje(String titulo, String head, String content, Alert.AlertType tipo) {
        Alert alerta = new Alert(null);
        alerta.setTitle(titulo);
        alerta.setHeaderText(head);
        alerta.setContentText(content);
        alerta.setAlertType(tipo);
        alerta.show();
    }

    @FXML
    void btnIngresarUsuario(ActionEvent event) {

        if(!(txtUserIngresar.getText().isEmpty() && txtPasswordIngresar.getText().isEmpty() ))
        {
            if(UsuarioLogic.autentificar(txtUserIngresar.getText(),txtPasswordIngresar.getText())){
                mostrarMensaje("Bienvenido ", null, " datos correctos",
                        Alert.AlertType.INFORMATION);
                ventana.cargarVentanaPrincipal();
                controllerPginaPrincipal.mostrarNombre(txtUserIngresar.getText());
            }
            else{
                mostrarMensaje("Datos de acceso incorrectos", null, "Registrese !! o asegúrese de introducir  los datos correctos ",
                        Alert.AlertType.ERROR);
            }
        }
        else {
            mostrarMensaje("Dejo los campos vacíos", null, "Asegúrese en llenar los campos",
                    Alert.AlertType.ERROR);
        }

    }

    @FXML
    void BtnRegistrarUsuario(ActionEvent event) {
        controllerRegitrarUsuario.registrarUsuario();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
