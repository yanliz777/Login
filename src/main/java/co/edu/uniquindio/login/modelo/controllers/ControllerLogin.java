package co.edu.uniquindio.login.modelo.controllers;
import co.edu.uniquindio.login.HelloApplication;
import co.edu.uniquindio.login.modelo.logic.UsuarioLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
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

    /**
     *Método que me permite cerrar una ventana
     * para darle apertura a otra y de esta manera no tener
     * varias ventanas abiertas
     */
    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnIngresarUsuario(ActionEvent event) {

        if(!(txtUserIngresar.getText().isEmpty() && txtPasswordIngresar.getText().isEmpty() ))
        {
            if(UsuarioLogic.autentificar(txtUserIngresar.getText(),txtPasswordIngresar.getText()))
            {
                cerrarVentana(btnIngresarUsuario);//cierra la ventana del login
                ventana.cargarVentanaPrincipal();//carga la ventana principal
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
        cerrarVentana(BtnRegistrarUsuario);//Me permite cerrar la ventana del login
        //para así darle apertura a la ventana de registro y no tener tantas ventanas abiertas.
        controllerRegitrarUsuario.registrarUsuario();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
