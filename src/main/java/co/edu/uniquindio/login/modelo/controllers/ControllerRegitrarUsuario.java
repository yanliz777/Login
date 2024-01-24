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
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRegitrarUsuario implements Initializable {
    HelloApplication ventana = new HelloApplication();

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

    public void registrarUsuario() {
        ventana.cargarRegistro();
    }

    /**
     *Método que me permite hacer el registro del usuario
     *haciendo validaciones para que llene los campos. Si el usuario
     * no se encuentra en la lista de usuarios se almacena y me carga la
     * ventana del login.
     */
    @FXML
    void btnRegistra_registro(ActionEvent event) {
        String name = txtName_registro.getText();
        String lastname = txtLastName_registro.getText();
        String email = txtEmail_registro.getText();
        String user = txtUser_registro.getText();
        String password = txtPassword_registro.getText();
        String repeatPassword= txtRepeatPassword_registro.getText();

        if(!name.isEmpty() && !lastname.isEmpty() && !email.isEmpty() &&
                !user.isEmpty() && !password.isEmpty()  && (repeatPassword.equals(password)))
        {
            Usuario usuario = new Usuario(user,password,name,lastname,email);//se crea el objeto

            if(UsuarioLogic.insertar(usuario))
            {
                cerrarVentana(btnRegistrar_registro);//cierra la ventana Login
                ventana.cargarVentanaLogin();
            }
            else{
                mostrarMensaje("Usuario ya existente", null, " revise los datos ingresados!!",
                        Alert.AlertType.ERROR);
            }
        }
        else {
            mostrarMensaje("Dejo campos vacíos", null, " revise los datos ingresados!!",
                    Alert.AlertType.ERROR);
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
    /**
     *Método que me permite cerrar una ventana
     * para darle apertura a otra y de esta manera no tener
     * varias ventanas abiertas, el botón que le envía por parámetro
     * es el de la ventana actual que sería el que se cierra
     */
    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
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
