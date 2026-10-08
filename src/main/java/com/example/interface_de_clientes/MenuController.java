package com.example.interface_de_clientes;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class MenuController {

    @FXML
    private void cadastrar(MouseEvent event){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Clientes cadastrados");
        alert.setContentText("mostraClientes");
        alert.show();
    }

    @FXML
    private void verClientes(MouseEvent event){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Clientes cadastrados");
        alert.setContentText("mostraClientes");
        alert.show();

    }
}
