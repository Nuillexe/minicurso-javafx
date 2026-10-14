package com.example.interface_de_clientes;

import com.example.interface_de_clientes.Controllers.MenuController;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

// A classe Main estende Application, transformando-se na porta de entrada oficial da aplicação JavaFX
public class Main extends Application{

    // O método start é obrigatório pelo JavaFX e é executado automaticamente quando o app abre
    @Override
    public void start(Stage stage) throws Exception {
        // 1. Carrega o arquivo FXML do menu e o converte em componentes visuais
        FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("/com/example/interface_de_clientes/menu.fxml"));

        // 2. Cria a Cena (Scene) oficial do aplicativo com o conteúdo carregado e tamanho fixo (600x400)
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // 3. Configura o título que aparece na barra superior da janela
        stage.setTitle("interface de cadastro de clientes");

        // 4. Coloca a cena dentro do palco (Stage) e exibe a janela na tela
        stage.setScene(scene);
        stage.show();

        // 5. SALVA a referência da cena principal na classe de Sessão
        // para que o NavigationManager possa trocar os elementos dela depois usando setRoot()
        Sessao.sceneInstance = scene;
    }
}