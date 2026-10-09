package com.example.interface_de_clientes.Utills;

import javafx.scene.control.Alert;

public class AlertManager {

    static public void alertError(String contentText){
        Alert alert= new Alert(Alert.AlertType.ERROR,contentText);
        alert.show();
    }

    static public void alertInformacao(String contentText){
        Alert alert= new Alert(Alert.AlertType.INFORMATION,contentText);
        alert.show();
    }
}
