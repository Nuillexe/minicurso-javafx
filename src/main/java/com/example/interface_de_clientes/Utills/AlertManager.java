package com.example.interface_de_clientes.Utills;

import javafx.scene.control.Alert;

public class AlertManager {

    // Método estático para exibir um alerta de ERRO padronizado na tela
    static public void alertError(String contentText){
        // Cria um novo objeto Alert do tipo ERROR passando a mensagem de texto recebida como parâmetro
        Alert alert = new Alert(Alert.AlertType.ERROR, contentText);
        // Exibe a janela de alerta para o usuário
        alert.show();
    }

    // Método estático para exibir um alerta de INFORMAÇÃO padronizado na tela
    static public void alertInformacao(String contentText){
        // Cria um novo objeto Alert do tipo INFORMATION passando a mensagem de texto recebida
        Alert alert = new Alert(Alert.AlertType.INFORMATION, contentText);
        // Exibe a janela de alerta para o usuário
        alert.show();
    }
}