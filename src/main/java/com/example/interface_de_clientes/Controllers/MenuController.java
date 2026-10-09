package com.example.interface_de_clientes.Controllers;

import com.example.interface_de_clientes.Sessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MenuController {

    @FXML
    private void cadastrar(MouseEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(
                CadastroController.class.getResource("/com/example/interface_de_clientes/cadastro.fxml")
        );

        Scene s= new Scene(loader.load(),600,400);
        Stage stage= Sessao.stageInstance;
        stage.setScene(s);
        stage.show();

    }

    @FXML
    private void verClientes(MouseEvent event){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Clientes cadastrados");
        alert.setContentText("Mostrar Clientes: \n"+ clientesFormatados(Sessao.listaDeClientes));
        alert.show();

    }

    private String clientesFormatados(ArrayList array){
        String resultado="";

        for(int i=0; i<array.size(); i++ ){
            resultado+=array.get(i).toString();
        }
        return resultado;
    }
}
