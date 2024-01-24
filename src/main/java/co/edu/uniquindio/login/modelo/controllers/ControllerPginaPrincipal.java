package co.edu.uniquindio.login.modelo.controllers;

import co.edu.uniquindio.login.modelo.logic.UsuarioLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPginaPrincipal implements Initializable {
    @FXML
    private Label lblUsuario;

    @FXML
    private AnchorPane lbl_usuario_pagPrincipal;

    public void mostrarNombre(String user) {
        lblUsuario.setText(user);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
