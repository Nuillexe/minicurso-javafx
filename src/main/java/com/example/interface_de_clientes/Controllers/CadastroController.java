package com.example.interface_de_clientes.Controllers;

import com.example.interface_de_clientes.Models.Cliente;
import com.example.interface_de_clientes.Utills.AlertManager;
import com.example.interface_de_clientes.Sessao;
import com.example.interface_de_clientes.Utills.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class CadastroController {

    // Anotações @FXML vinculam as caixas de texto da tela (FXML) com o código Java
    @FXML
    TextField campoNome;

    @FXML
    TextField campoIdade;

    @FXML
    TextField campoTelefone;

    // Método acionado ao clicar no botão de cadastrar
    @FXML
    private void cadastrar(MouseEvent event){
        // Bloco try-catch para tentar executar o cadastro e tratar possíveis erros (exceções)
        try {
            cadastro(); // Tenta realizar o processo de cadastro

        } catch (java.lang.NumberFormatException e){
            // Erro gerado se o usuário digitar letras no campo de idade que espera números
            AlertManager.alertError("CPF e Idade estão invalidos");
        } catch (IllegalArgumentException e){
            // Erro genérico para argumentos inválidos
            AlertManager.alertError("Pode rever se os campos estão devidamente preenchidos");
        } catch (IOException e){
            // Erro caso aconteça algum problema ao carregar o arquivo FXML do menu
            AlertManager.alertError("Erro ao carregar a tela de menu");
        } finally {
            // O bloco 'finally' SEMPRE roda no final, independentemente de ter dado erro ou sucesso.
            // Aqui garantimos que o usuário é sempre mandado de volta para o menu.
                NavigationManager.irPara("/com/example/interface_de_clientes/menu.fxml");

        }
    }

    // Método interno que faz a leitura dos campos e validações de dados
    private void cadastro() throws IOException{
        // Pega o texto digitado nas caixas de texto
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText()); // Converte o texto da idade para número inteiro
        String telefone = campoTelefone.getText();

        // Validação básica para garantir que os campos não estão nulos
        if(campoTelefone == null || nome == null || campoIdade == null){
            AlertManager.alertError("Há campos vazios");
            return; // Para a execução se houver erro
        }

        // Validação do telefone: deve ter exatamente 11 dígitos e conter apenas números
        if(telefone.length() != 11 || !telefone.matches("\\d+")){
            AlertManager.alertError("CPF deve ter somente 11 numeros"); // (Mensagem mantida conforme o seu código)
            return;
        }

        // Se passou por todas as validações, cria um novo objeto Cliente e adiciona na lista global da Sessão
        Sessao.listaDeClientes.add(new Cliente(nome, telefone, idade));
        AlertManager.alertInformacao("O cadastro foi concluido com sucesso!");
    }
}