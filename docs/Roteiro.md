# Roteiro do Minicurso

*OBS: No [GitHub do projeto, na branch projeto-base](https://github.com/Nuillexe/minicurso-javafx/tree/projeto-base), há o projeto pré-pronto ideal para a aprendizagem do curso. Ao construir o projeto a partir dele, pode-se pular a Etapa 3.*

## Índice
- [Etapa 1: Apresentação do JavaFX e Criando um Projeto](#1-etapa-apresentação-do-javafx-e-criando-um-projeto)
- [Etapa 2: Verificando Bugs e Testando o Ambiente](#2-etapa-verificando-bugs-e-testando-o-ambiente)
- [Etapa 3: Criação dos Packages, Classes e Arquivos FXML](#3-etapa-criação-dos-packages-classes-e-arquivos-fxml)
- [Etapa 4: Construindo a Tela de Menu com o Scene Builder](#4-etapa-construindo-a-tela-de-menu-com-o-scene-builder)
- [Etapa 5: Programando o MenuController](#5-etapa-programando-o-menucontroller)
- [Etapa 6: Entendendo a Geração da Tela e o NavigationManager](#6-etapa-entendendo-a-geração-da-tela-e-o-navigationmanager)
- [Etapa 7: Construindo a Tela de Cadastro e o CadastroController](#7-etapa-construindo-a-tela-de-cadastro-e-o-cadastrocontroller)
- [Etapa 8: Organizando o AlertManager e Tratamento de Exceções](#8-etapa-organizando-o-alertmanager-e-tratamento-de-exceções)

---

## 1° Etapa: Apresentação do JavaFX e Criando um Projeto
O JavaFX é um framework Java que permite criar aplicativos desktop modernos. A interface gráfica é construída através de arquivos `.fxml`, que funcionam como as telas propriamente ditas. Assim como o HTML, o FXML é uma linguagem de marcação estruturada e também pode ser estilizada utilizando arquivos CSS.

A pasta `resources` tem a finalidade de armazenar todos os recursos gráficos (arquivos FXML, estilos CSS e imagens) do nosso projeto.

### Como deixamos as telas interativas?
Todo o código Java da nossa aplicação fica dentro do pacote `src`. Para cada tela, criamos uma classe correspondente chamada de **Controller**. Neles são processados os eventos de clique, validações e dados inseridos nas telas (funcionando de forma semelhante ao papel do JavaScript em relação ao HTML).

### O Padrão de Arquitetura MVC
O projeto segue o padrão **Model-View-Controller (MVC)**:
- **Model**: Faz referência ao pacote de dados correspondente às classes de entidades do sistema (neste minicurso, a classe [Cliente](/src/main/java/com/example/interface_de_clientes/Models/Cliente.java)).
- **View**: Diz respeito a toda a parte visual e de interação com o usuário, representada pelos arquivos FXML.
- **Controller**: Representa os recursos utilizados para controlar o fluxo da aplicação. No nosso curso, são representados pelas classes do pacote `Controllers` ([MenuController](/src/main/java/com/example/interface_de_clientes/Controllers/MenuController.java) e [CadastroController](/src/main/java/com/example/interface_de_clientes/Controllers/CadastroController.java)).

### Criando um Novo Projeto no IntelliJ IDEA:
1. Na tela de criação de projeto (*New Project*), clique em **JavaFX**.
2. Escreva o nome do projeto: `Interface de Cadastro de Clientes`.
3. Selecione a pasta onde ele será salvo.
4. Selecione a linguagem **Java**.
5. Selecione o Build System como **Maven** (gerenciador de dependências que organiza as bibliotecas do projeto).
6. Defina o *Artifact* (nome do executável do projeto).

[Voltar ao índice](#índice)

---

## 2° Etapa: Verificando Bugs e Testando o Ambiente
Automaticamente, quando se cria um projeto JavaFX padrão, é gerada uma aplicação de exemplo (semelhante a um "Hello World"). Para testar se o seu ambiente está configurado corretamente, clique no botão **Run** (*Executar*).

Se a janela padrão abrir com sucesso, está tudo ok! Caso contrário, consulte o [Manual de Resolução de Problemas](/docs/Manual%20de%20resolucao%20de%20bugs.md).

[Voltar ao índice](#índice)

---

## 3° Etapa: Criação dos Packages, Classes e Arquivos FXML
O projeto será organizado nos seguintes pacotes:
- **Controllers**: Contém as classes [MenuController](/src/main/java/com/example/interface_de_clientes/Controllers/MenuController.java) e [CadastroController](/src/main/java/com/example/interface_de_clientes/Controllers/CadastroController.java).
- **Models**: Composta exclusivamente pela classe [Cliente](/src/main/java/com/example/interface_de_clientes/Models/Cliente.java).
- **Utils**: Ferramentas auxiliares que facilitam o desenvolvimento:
  - [NavigationManager](/src/main/java/com/example/interface_de_clientes/Utills/NavigationManager.java): Gerencia a navegação entre telas.
  - [AlertManager](/src/main/java/com/example/interface_de_clientes/Utills/AlertManager.java): Facilita a exibição de caixas de diálogo e alertas.

#### Classes Launcher.java e Main.java
- A classe [Launcher](/src/main/java/com/example/interface_de_clientes/Launcher.java) é responsável por inicializar o projeto chamando a classe [Main](/src/main/java/com/example/interface_de_clientes/Main.java). Essa separação evita erros de componentes de runtime em projetos modularizados do JavaFX.
- A classe [Main](/src/main/java/com/example/interface_de_clientes/Main.java) carrega a tela inicial do sistema.

#### Classe Sessão
A classe [Sessao](/src/main/java/com/example/interface_de_clientes/Sessao.java) funciona como um repositório global em memória para armazenar a lista de clientes e a referência da cena principal (*sceneInstance*), permitindo acesso prático de qualquer parte do sistema.

#### Arquivos FXML
Na pasta `resources/com/example/interface_de_clientes/`, criamos os arquivos `menu.fxml` e `cadastro.fxml`, que estruturam visualmente as nossas telas.

[Voltar ao índice](#índice)

---

## 4° Etapa: Construindo a Tela de Menu com o Scene Builder
1. **Abrindo o FXML**: Clique com o botão direito em `menu.fxml` e selecione **Open in SceneBuilder**. (Na primeira vez, o IntelliJ pedirá para você apontar onde o executável do Scene Builder está instalado).
2. **Adicionando Componentes**:
  - Arraste um **Label** para a tela. No painel *Properties*, altere o campo *Text* para `Menu`.
  - Arraste dois **Buttons**. No primeiro, defina o texto como `Cadastrar novos Clientes`. No segundo, defina como `Ver Clientes cadastrados`.
  - Arraste uma **TextArea** para exibir os clientes cadastrados na tela.
3. **Configurando IDs e Eventos (Aba Code)**:
  - No botão de cadastro: defina o *fx:id* como `cadastrarBtn` e em *On Mouse Clicked* digite `cadastrar`.
  - No botão de ver clientes: defina o *fx:id* como `verBtn` e em *On Mouse Clicked* digite `verClientes`.
  - Na TextArea: defina o *fx:id* como `txtAreaClientes`.
4. **Vinculando o Controller**: No painel inferior esquerdo do Scene Builder (*Controller class*), informe o caminho completo: `com.example.interface_de_clientes.Controllers.MenuController`.

[Voltar ao índice](#índice)

---

## 5° Etapa: Programando o MenuController
Para conectar os elementos visuais criados no Scene Builder ao código Java, declaramos os componentes utilizando a anotação `@FXML` com exatamente o mesmo nome dos identificadores definidos na tela.

### Código do MenuController
```java
package com.example.interface_de_clientes.Controllers;

import com.example.interface_de_clientes.Sessao;
import com.example.interface_de_clientes.Utills.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.util.List;

public class MenuController {

    @FXML
    Button cadastrarBtn;

    @FXML
    Button verBtn;

    @FXML
    TextArea txtAreaClientes;

    @FXML
    private void cadastrar(MouseEvent event) {
        NavigationManager.irPara("/com/example/interface_de_clientes/cadastro.fxml");
    }

    @FXML
    private void verClientes(MouseEvent event) {
        if (Sessao.listaDeClientes == null || Sessao.listaDeClientes.isEmpty()) {
            txtAreaClientes.setText("Não há nenhum cliente cadastrado ainda");
            return;
        }
        txtAreaClientes.setText(clientesFormatados(Sessao.listaDeClientes));
    }

    private String clientesFormatados(List array) {
        String resultado = "";
        for (int i = 0; i < array.size(); i++) {
            resultado += array.get(i).toString();
        }
        return resultado;
    }
}
```
*Veja a implementação completa na classe [MenuController](/src/main/java/com/example/interface_de_clientes/Controllers/MenuController.java).*

[Voltar ao índice](#índice)

---

## 6° Etapa: Entendendo a Geração da Tela e o NavigationManager
A inicialização da interface costuma ocorrer na classe [Main](/src/main/java/com/example/interface_de_clientes/Main.java) através do carregamento de um arquivo FXML transformado em uma `Scene` e exibido em um `Stage`:

- **FXMLLoader**: Responsável por ler os dados do arquivo de texto FXML e convertê-los em objetos visuais.
- **Scene**: A cena que agrupa os componentes visuais.
- **Stage**: A janela principal do sistema operacional.

Para evitar repetir códigos complexos em cada controller a cada mudança de tela, utilizamos o [NavigationManager](/src/main/java/com/example/interface_de_clientes/Utills/NavigationManager.java) em conjunto com a [Sessao](/src/main/java/com/example/interface_de_clientes/Sessao.java).

### Código da Classe Main
```java
package com.example.interface_de_clientes;

import com.example.interface_de_clientes.Controllers.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("/com/example/interface_de_clientes/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Interface de Cadastro de Clientes");
        stage.setScene(scene);
        stage.show();

        // SALVA a referência da cena principal na Sessão para podermos reutilizá-la depois
        Sessao.sceneInstance = scene;
    }
}
```
*Veja a implementação completa na classe [Main](/src/main/java/com/example/interface_de_clientes/Main.java).*

### Código da Classe Sessao
```java
package com.example.interface_de_clientes;

import com.example.interface_de_clientes.Models.Cliente;
import javafx.scene.Scene;
import java.util.ArrayList;

public class Sessao {
    static public ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    static public Scene sceneInstance;
}
```
*Veja a implementação completa na classe [Sessao](/src/main/java/com/example/interface_de_clientes/Sessao.java).*

### Código da Classe NavigationManager
```java
package com.example.interface_de_clientes.Utills;

import com.example.interface_de_clientes.Sessao;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class NavigationManager {

     public static void irPara(String caminhoFxml){
         try {
             FXMLLoader loader = new FXMLLoader(NavigationManager.class.getResource(caminhoFxml));
             // Altera diretamente o conteúdo raiz (root) da cena principal guardada na Sessão
             Sessao.sceneInstance.setRoot(loader.load());

         } catch (IOException e){
             AlertManager.alertError("Não foi possível trocar de tela");
         }
     }
}
```
*Veja a implementação completa na classe [NavigationManager](/src/main/java/com/example/interface_de_clientes/Utills/NavigationManager.java).*

[Voltar ao índice](#índice)

---

## 7° Etapa: Construindo a Tela de Cadastro e o CadastroController
Na tela de cadastro (`cadastro.fxml`), estruturamos os campos de entrada (*TextField*) para **Nome**, **Idade** e **Telefone**, além do botão de envio associado ao método de cadastro.

### Código do CadastroController
```java
package com.example.interface_de_clientes.Controllers;

import com.example.interface_de_clientes.Models.Cliente;
import com.example.interface_de_clientes.Utills.AlertManager;
import com.example.interface_de_clientes.Sessao;
import com.example.interface_de_clientes.Utills.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CadastroController {

    @FXML
    TextField campoNome;

    @FXML
    TextField campoIdade;

    @FXML
    TextField campoTelefone;

    @FXML
    private void cadastrar(MouseEvent event){
        try {
            cadastro();
        } catch (java.lang.NumberFormatException e){
            AlertManager.alertError("CPF e Idade estão inválidos");
        } catch (IllegalArgumentException e){
            AlertManager.alertError("Pode rever se os campos estão devidamente preenchidos");
        } finally {
            NavigationManager.irPara("/com/example/interface_de_clientes/menu.fxml");
        }
    }

    private void cadastro() {
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText());
        String telefone = campoTelefone.getText();

        if (campoTelefone == null || nome == null || campoIdade == null){
            AlertManager.alertError("Há campos vazios");
            return;
        }
        if (telefone.length() != 11 || !telefone.matches("\\d+")){
            AlertManager.alertError("O telefone deve ter somente 11 números");
            return;
        }

        Sessao.listaDeClientes.add(new Cliente(nome, telefone, idade));
        AlertManager.alertInformacao("O cadastro foi concluído com sucesso!");
    }
}
```
*Veja a implementação completa na classe [CadastroController](/src/main/java/com/example/interface_de_clientes/Controllers/CadastroController.java).*

[Voltar ao índice](#índice)

---

## 8° Etapa: Organizando o AlertManager e Tratamento de Exceções
Para padronizar e simplificar a emissão de avisos visuais na tela sem duplicar código, isolamos a lógica de criação de caixas de diálogo na classe utilitária [AlertManager](/src/main/java/com/example/interface_de_clientes/Utills/AlertManager.java).

### Código do AlertManager
```java
package com.example.interface_de_clientes.Utills;

import javafx.scene.control.Alert;

public class AlertManager {

    public static void alertError(String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR, contentText);
        alert.show();
    }

    public static void alertInformacao(String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, contentText);
        alert.show();
    }
}
```
*Veja a implementação completa na classe [AlertManager](/src/main/java/com/example/interface_de_clientes/Utills/AlertManager.java).*

[Voltar ao índice](#índice)