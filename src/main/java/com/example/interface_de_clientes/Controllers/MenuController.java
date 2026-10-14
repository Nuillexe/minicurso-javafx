package com.example.interface_de_clientes.Controllers;
import com.example.interface_de_clientes.Sessao;
import com.example.interface_de_clientes.Utills.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class MenuController {

    // Anotação @FXML vincula os componentes visuais criados no Scene Builder com o código Java
    @FXML
    Button cadastrarBtn;

    @FXML
    Button verBtn;

    @FXML
    TextArea txtAreaClientes; // Caixa de texto grande onde vamos exibir a lista de clientes

    // Método acionado quando o usuário clica no botão de cadastrar
    @FXML
    private void cadastrar(MouseEvent event) throws Exception{
        // Usa o NavigationManager para trocar a tela atual para o arquivo de cadastro
        NavigationManager.irPara("/com/example/interface_de_clientes/cadastro.fxml");
    }

    // Método acionado quando o usuário clica para ver os clientes cadastrados
    @FXML
    private void verClientes(MouseEvent event){

        // Validação: Verifica se a lista é nula ou se está vazia antes de tentar exibir
        if(Sessao.listaDeClientes == null || Sessao.listaDeClientes.isEmpty()) {
            // Se estiver vazia, avisa o usuário na tela e usa 'return' para parar a execução aqui
            txtAreaClientes.setText("Não há nenhum cliente cadastrado ainda");
            return;
        }

        // Se houver clientes, chama o método de formatação e joga o texto dentro da TextArea
        txtAreaClientes.setText(clientesFormatados(Sessao.listaDeClientes));
    }

    // Método auxiliar para percorrer a lista e transformar os objetos em um texto legível
    private String clientesFormatados(List array){
        String resultado = ""; // Começa com uma string vazia

        // Loop tradicional para passar por cada item da lista do primeiro ao último
        for(int i = 0; i < array.size(); i++ ){
            // Pega o objeto na posição 'i', converte para String (usando o toString do Cliente) e acumula
            resultado += array.get(i).toString();
        }

        return resultado; // Retorna o texto completo pronto para ser exibido
    }
}