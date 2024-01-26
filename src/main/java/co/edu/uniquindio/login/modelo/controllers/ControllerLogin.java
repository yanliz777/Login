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
    HelloApplication ventana = new HelloApplication();//Para darle manejo a las ventanas
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
     * varias ventanas abiertas, el botón que le envía por parámetro
     * es el de la ventana actual que sería el que se cierra
     */
    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    /**
     *Método que me permite realizar el ingreso/login
     * al sistema, si no está registrado debe hacerlo primero
     */
    @FXML
    void btnIngresarUsuario(ActionEvent event) {

        String user = txtUserIngresar.getText();
        String password = txtPasswordIngresar.getText();

        if(!(user.isEmpty() && password.isEmpty() ))//si no están vacíos entran al if
        {
            if(UsuarioLogic.autentificar(user,password))
            {
                cerrarVentana(btnIngresarUsuario);//cierra la ventana del login
                ventana.cargarVentanaPrincipal();//carga la ventana principal
                //controllerPginaPrincipal.mostrarNombre(user);
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

    /**
     *Método que se comunica con controllerRegitrarUsuario para hacer
     * el registro respectivo del usuario en su respectivo controlador
     */
    @FXML
    void BtnRegistrarUsuario(ActionEvent event) {
        cerrarVentana(BtnRegistrarUsuario);//Me permite cerrar la ventana del login
        //para así darle apertura a la ventana de registro y no tener tantas ventanas abiertas.
        controllerRegitrarUsuario.registrarUsuario();//nos comunicamos con el controlador controllerRegitrarUsuario
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
