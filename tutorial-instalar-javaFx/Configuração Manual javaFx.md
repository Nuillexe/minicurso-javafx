# Configurando JavaFX manualmente no IntelliJ IDEA

Este guia apresenta o procedimento para configurar o JavaFX manualmente no IntelliJ IDEA, sem utilizar Maven ou Gradle para gerenciar as dependências.

## 1. Pré-requisitos

Antes de começar, você precisará de:

- IntelliJ IDEA.
- JDK instalado.
- JavaFX SDK compatível com a versão do JDK.

**Combinações recomendadas:**

| JDK | JavaFX SDK |
|---|---|
| Java 17 | JavaFX 17 |
| Java 21 | JavaFX 21 |

O JavaFX não está incluído no JDK desde o Java 11. Portanto, é necessário baixar seu SDK separadamente.

> **Importante:** não é obrigatório utilizar exatamente as versões indicadas na tabela. Entretanto, alinhar as versões do JDK e do JavaFX simplifica a configuração e evita problemas de compatibilidade.

## 2. Instalar o JDK

Caso ainda não tenha um JDK instalado, você pode baixá-lo de uma distribuição confiável:

- [Eclipse Temurin — downloads oficiais](https://adoptium.net/temurin/releases/)

Selecione a versão desejada, o sistema operacional Windows, a arquitetura x64 e o pacote JDK.

Após a instalação, abra o terminal e execute:

```bash
java -version
javac -version
```

Os comandos devem exibir a versão do Java e do compilador instalados.

Neste tutorial, utilizaremos Java 21 como exemplo, mas o procedimento também funciona com Java 17, desde que seja utilizado um JavaFX compatível.

Se o IntelliJ já estiver configurado com um JDK compatível, não será necessário instalar outro.

## 3. Baixar o JavaFX SDK

Acesse uma das páginas oficiais:

- [OpenJFX — site oficial](https://openjfx.io/)
- [Oracle — downloads do JavaFX](https://www.oracle.com/java/technologies/downloads/javafx/)

Baixe o **JavaFX SDK** correspondente ao seu sistema operacional e à arquitetura do computador. Para Windows de 64 bits, escolha o pacote Windows x64 SDK.

Escolha a versão compatível com seu JDK:

- JDK 17 → JavaFX 17.
- JDK 21 → JavaFX 21.

Extraia o arquivo ZIP para um diretório de fácil acesso. Por exemplo:

```text
C:\javafx-sdk-21\
```

A estrutura deverá ser semelhante a:

```text
C:\javafx-sdk-21\
├── bin\
└── lib\
    ├── javafx.base.jar
    ├── javafx.controls.jar
    ├── javafx.fxml.jar
    ├── javafx.graphics.jar
    └── ...
```

A pasta `lib` contém as bibliotecas necessárias para configurar o projeto.

> Se você baixou o JavaFX 17, o diretório poderá ser `C:\javafx-sdk-17\`. Utilize sempre o caminho real da pasta em que o SDK foi extraído.

## 4. Criar um projeto Java no IntelliJ

1. Abra o IntelliJ IDEA.
2. Clique em **New Project**.
3. Selecione **Java**.
4. Defina o nome do projeto, por exemplo, `MeuProjetoJavaFX`.
5. Selecione o JDK instalado, seja ele Java 17 ou Java 21.
6. Escolha a opção de build **IntelliJ**, quando disponível. Não selecione Maven ou Gradle.
7. Crie o projeto.

A estrutura inicial será semelhante a:

```text
MeuProjetoJavaFX/
└── src/
    └── Main.java
```

A localização de algumas opções pode variar conforme a versão do IntelliJ IDEA.

## 5. Adicionar o JavaFX SDK ao projeto

Precisamos informar ao IntelliJ onde estão as bibliotecas do JavaFX, para que o editor reconheça classes como `Application`, `Scene` e `Button`.

1. Acesse **File → Project Structure**.
2. Selecione **Libraries**.
3. Clique no botão `+`.
4. Escolha **Java**.
5. Navegue até a pasta `lib` do JavaFX SDK.

Exemplo para JavaFX 21:

```text
C:\javafx-sdk-21\lib
```

Exemplo para JavaFX 17:

```text
C:\javafx-sdk-17\lib
```

6. Selecione a pasta e confirme.
7. Se o IntelliJ perguntar a quais módulos associar a biblioteca, selecione o módulo do projeto.
8. Clique em **Apply** e depois em **OK**.

Agora as classes do JavaFX deverão ser reconhecidas pelo editor.

**Atenção:** adicionar a biblioteca ao projeto permite que o IntelliJ reconheça as classes, mas ainda precisamos configurar o ambiente de execução.

## 6. Configurar as opções da JVM

O Java precisa saber onde estão os módulos do JavaFX quando executar o programa.

1. Abra **Run → Edit Configurations**.
2. Selecione a configuração da classe principal. Se necessário, crie uma configuração do tipo **Application**.
3. Localize o campo **VM options**. Em algumas versões, pode ser necessário acessar **Modify options → Add VM options**.
4. Adicione os argumentos abaixo, substituindo o caminho pelo diretório real do JavaFX SDK:

```text
--module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml
```

Para JavaFX 17, por exemplo:

```text
--module-path "C:\javafx-sdk-17\lib" --add-modules javafx.controls,javafx.fxml
```

5. Clique em **Apply** e depois em **OK**.

### O que significam esses argumentos?

- `--module-path`: indica onde estão os módulos do JavaFX.
- `--add-modules javafx.controls`: disponibiliza componentes gráficos, como botões, campos de texto e tabelas.
- `--add-modules javafx.fxml`: disponibiliza o suporte ao FXML, utilizado para descrever interfaces em arquivos XML.

Se o projeto não utilizar FXML, você pode remover `javafx.fxml` dos argumentos.

## 7. Criar uma aplicação de teste

Crie a classe `Main.java` dentro da pasta `src`:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label mensagem = new Label("JavaFX configurado!");
        Button botao = new Button("Clique aqui");

        botao.setOnAction(event ->
            mensagem.setText("Está funcionando!")
        );

        VBox layout = new VBox(10, mensagem, botao);
        Scene cena = new Scene(layout, 400, 250);

        stage.setTitle("Teste JavaFX");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Execute a classe `Main`.

Se uma janela aparecer com a mensagem **"JavaFX configurado!"** e um botão funcional, a configuração está concluída.

## 8. Projetos com `module-info.java`

Este tutorial utiliza um projeto não modular, sem `module-info.java`, para simplificar a configuração inicial.

Se o projeto já possuir esse arquivo, não o remova automaticamente. Configure os módulos utilizados pela aplicação. Por exemplo:

```java
module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
}
```

Substitua `com.example.demo` pelo nome real do pacote.

Nesse caso, o projeto também precisará estar organizado de acordo com o sistema de módulos do Java. O argumento `--module-path` continua necessário na execução manual.

## 9. Problemas comuns

### Erro: `package javafx.application does not exist`

**Possível causa:** o JavaFX SDK não foi adicionado corretamente às bibliotecas do projeto.

**Solução:** confira se a pasta `lib` foi adicionada em **Project Structure → Libraries**.

### Erro: `JavaFX runtime components are missing`

**Possível causa:** o JavaFX está disponível para compilação, mas não foi configurado corretamente para execução.

**Solução:** confira as VM options da configuração de execução e verifique se o caminho está correto.

### Erro: `Module javafx.controls not found`

**Possível causa:** o caminho informado em `--module-path` está incorreto ou aponta para a pasta errada.

**Solução:** confirme que o caminho termina na pasta `lib` do JavaFX SDK e que nela existe o arquivo `javafx.controls.jar`.

### Erro relacionado à versão do Java

**Possível causa:** incompatibilidade entre o JDK utilizado e a versão do JavaFX.

**Solução:** confira a versão do JDK em **File → Project Structure → Project** e utilize um JavaFX compatível. Para este tutorial, utilize JDK 17 com JavaFX 17 ou JDK 21 com JavaFX 21.

### O editor reconhece JavaFX, mas a aplicação não abre

**Possível causa:** a biblioteca foi adicionada ao projeto, mas os argumentos de execução não foram configurados ou estão associados a outra configuração.

**Solução:** abra **Run → Edit Configurations**, selecione a configuração utilizada e confira as VM options.

## 10. Checklist de configuração

- [ ] O JDK está instalado e configurado no IntelliJ.
- [ ] A versão do JavaFX é compatível com o JDK.
- [ ] O JavaFX SDK foi baixado e extraído.
- [ ] A pasta `lib` foi adicionada às bibliotecas do projeto.
- [ ] As VM options apontam para o caminho correto.
- [ ] A aplicação de teste abre uma janela.
- [ ] Os componentes da interface respondem às interações.

## Referências oficiais

- [OpenJFX — Getting Started](https://openjfx.io/openjfx-docs/index.html)
- [OpenJFX — documentação de instalação](https://openjfx.io/openjfx-docs/install-javafx)
- [JetBrains — documentação do IntelliJ IDEA](https://www.jetbrains.com/help/idea/)

