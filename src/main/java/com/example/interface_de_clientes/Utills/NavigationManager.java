package com.example.interface_de_clientes.Utills;

import com.example.interface_de_clientes.Sessao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationManager {

     public static void irPara(String caminhoFxml) throws IOException {
         FXMLLoader loader= new FXMLLoader(NavigationManager.class.getResource(caminhoFxml));
         Scene scene= new Scene(loader.load(),600,400);
         Stage stage= Sessao.stageInstance;
         stage.setScene(scene);
         stage.show();
     }
}
