package com.example.interface_de_clientes;

import com.example.interface_de_clientes.Models.Cliente;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

// A classe Sessao funciona como um "repositório global" para guardar informações
// que precisam ser acessadas de qualquer lugar do projeto (como a lista de clientes e a cena atual)
public class Sessao {

    // Lista global que armazena todos os clientes cadastrados durante a execução do programa
    static public ArrayList listaDeClientes = new ArrayList<Cliente>();

    // Guarda a referência da cena principal para permitir a troca de telas via NavigationManager
    static public Scene sceneInstance;

}