package com.example.interface_de_clientes.Utills;

import com.example.interface_de_clientes.Sessao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationManager {

    // Método estático para trocar de tela passando o caminho do arquivo FXML de destino
    public static void irPara(String caminhoFxml){
        try {
            // 1. Cria um FXMLLoader apontando para o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(NavigationManager.class.getResource(caminhoFxml));

            // 2. Carrega o novo arquivo e altera diretamente o conteúdo raiz (root) da cena principal guardada na Sessão,
            // evitando criar uma nova janela ou redimensionar do zero
            Sessao.sceneInstance.setRoot(loader.load());

        } catch (IOException e){
            // Se houver algum problema ao achar ou carregar o arquivo FXML, exibe uma mensagem de erro na tela
            AlertManager.alertError("Não foi possivel trocar de tela");
        }
    }
}