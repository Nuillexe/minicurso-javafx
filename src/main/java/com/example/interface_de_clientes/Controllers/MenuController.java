package com.example.interface_de_clientes.Controllers;

import com.example.interface_de_clientes.Sessao;
import com.example.interface_de_clientes.Utills.NavigationManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MenuController {
//a
    @FXML
    private void cadastrar(MouseEvent event) throws Exception{

    }

    @FXML
    private void verClientes(MouseEvent event){

    }

    private String clientesFormatados(ArrayList array){
        String resultado="";

        for(int i=0; i<array.size(); i++ ){
            resultado+=array.get(i).toString();
        }
        return resultado;
    }
 
}
