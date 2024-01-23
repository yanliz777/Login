package co.edu.uniquindio.login.modelo.controllers;

import co.edu.uniquindio.login.HelloApplication;
import co.edu.uniquindio.login.modelo.beans.Usuario;
import co.edu.uniquindio.login.modelo.logic.UsuarioLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRegitrarUsuario implements Initializable {
    HelloApplication ventana = new HelloApplication();

    public void registrarUsuario() {
        ventana.cargarRegistro();
    }

    @FXML
    private Button btnRegistrar_registro;

    @FXML
    private Button btnEliminar_registro;

    @FXML
    private Button btnModificar_registro;

    @FXML
    private TextField txtPassword_registro;

    @FXML
    private TextField txtLastName_registro;

    @FXML
    private TextField txtUser_registro;

    @FXML
    private TextField txtRepeatPassword_registro;

    @FXML
    private TextField txtEmail_registro;

    @FXML
    private Button btnBuscar_registro;

    @FXML
    private TextField txtName_registro;

    @FXML
    void btnRegistra_registro(ActionEvent event) {

        String name = txtName_registro.getText();
        String lastname = txtLastName_registro.getText();
        String email = txtEmail_registro.getText();
        String user = txtUser_registro.getText();
        String pasword = txtPassword_registro.getText();
        String repeatPassword= txtRepeatPassword_registro.getText();

        if(!(name.isEmpty() && lastname.isEmpty() && email.isEmpty() &&
                user.isEmpty() && pasword.isEmpty() && repeatPassword.equals(txtPassword_registro)))
        {
            Usuario usuario = new Usuario(user,pasword,name,lastname,email);

            if(UsuarioLogic.insertar(usuario)){
                ventana.cargarVentanaLogin();
            }
            else{
                mostrarMensaje("Usuario ya existente", null, " revise los datos ingresados!!",
                        Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void btnModificar_registro(ActionEvent event) {
        String name = txtName_registro.getText();
        String lastname = txtLastName_registro.getText();
        String email = txtEmail_registro.getText();
        String user = txtUser_registro.getText();
        String pasword = txtPassword_registro.getText();
        String repeatPassword= txtRepeatPassword_registro.getText();

        if(!(name.isEmpty() && lastname.isEmpty() && email.isEmpty() &&
                user.isEmpty() && pasword.isEmpty() && repeatPassword.equals(txtPassword_registro)))
        {
            Usuario usuario = new Usuario(user,pasword,name,lastname,email);

            if(UsuarioLogic.modificar(usuario)){
                mostrarMensaje("Usuario modificado exitosamente", null, " Felicitaciones!",
                        Alert.AlertType.INFORMATION);
            }
            else{
                mostrarMensaje("Usuario no encontrado", null, " revise los datos ingresados!!",
                        Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void btnEliminar_registro(ActionEvent event) {
        String name = txtName_registro.getText();
        String lastname = txtLastName_registro.getText();
        String email = txtEmail_registro.getText();
        String user = txtUser_registro.getText();
        String pasword = txtPassword_registro.getText();
        String repeatPassword= txtRepeatPassword_registro.getText();

        if(!(name.isEmpty() && lastname.isEmpty() && email.isEmpty() &&
                user.isEmpty() && pasword.isEmpty() && repeatPassword.equals(txtPassword_registro)))
        {
            Usuario usuario = new Usuario(user,pasword,name,lastname,email);

            if(UsuarioLogic.eliminar(user)){
                mostrarMensaje("Usuario eliminado exitosamente", null, " Felicitaciones!",
                        Alert.AlertType.INFORMATION);
            }
            else{
                mostrarMensaje("Usuario no encontrado", null, " revise los datos ingresados!!",
                        Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void btnBuscar_registro(ActionEvent event) {

    }

    private void mostrarMensaje(String titulo, String head, String content, Alert.AlertType tipo) {
        Alert alerta = new Alert(null);
        alerta.setTitle(titulo);
        alerta.setHeaderText(head);
        alerta.setContentText(content);
        alerta.setAlertType(tipo);
        alerta.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
