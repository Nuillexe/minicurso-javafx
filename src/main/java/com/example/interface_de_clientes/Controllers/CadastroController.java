package com.example.interface_de_clientes.Controllers;

import com.example.interface_de_clientes.Models.Cliente;
import com.example.interface_de_clientes.Utills.AlertManager;
import com.example.interface_de_clientes.Sessao;
import com.example.interface_de_clientes.Utills.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class CadastroController {
    @FXML
    TextField campoNome;

    @FXML
    TextField campoIdade;

    @FXML
    TextField campoCPF;

    @FXML
    private void cadastrar(MouseEvent event){
        try {
            cadastro();

        }catch (java.lang.NumberFormatException e){
            AlertManager.alertError("CPF e Idade estão invalidos");
        }catch (IllegalArgumentException e){
            AlertManager.alertError("Pode rever se os campos estão devidamente preenchidos");
        }catch (IOException e){
            AlertManager.alertError("Erro ao carregar a tela de menu");
        }
    }

    private void cadastro() throws IOException{
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText());
        String cpf= campoCPF.getText();

        if(cpf==null || nome==null || campoIdade==null){
            AlertManager.alertError("Há campos vazios");
            return;
        }
        if(cpf.length()!=11 || !cpf.matches("\\d+")){
            AlertManager.alertError("CPF deve ter somente 11 numeros");
            return;
        }

        Sessao.listaDeClientes.add(new Cliente(nome, cpf, idade));
        AlertManager.alertInformacao("O cadastro foi concluido com sucesso!");

        NavigationManager.irPara("/com/example/interface_de_clientes/menu.fxml");
    }
}
