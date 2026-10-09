package com.example.interface_de_clientes;
import com.example.interface_de_clientes.Controllers.MenuController;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
public class Main extends  Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader= new FXMLLoader(MenuController.class.getResource("/com/example/interface_de_clientes/menu.fxml"));//
        Scene scene= new Scene(fxmlLoader.load(), 600,400);
        stage.setTitle("interface de cadstro de clientes");
        stage.setScene(scene);
        stage.show();
        Sessao.stageInstance=stage;
    }
}

/*
*
*
*
*
* */
