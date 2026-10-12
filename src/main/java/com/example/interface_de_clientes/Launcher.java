package com.example.interface_de_clientes;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        // Inicia a aplicação JavaFX chamando a classe Main real.
        // Isso evita erros de componentes de runtime em projetos modularizados.
        Application.launch(Main.class, args);
    }
}
