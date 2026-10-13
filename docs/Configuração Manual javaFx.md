# Configuração Manual do JavaFX no IntelliJ IDEA Community Edition

> **OBSERVAÇÃO IMPORTANTE:**  
> Se o seu ambiente estiver com acesso normal à internet e o **Maven** estiver funcionando perfeitamente, **você não precisa se preocupar em baixar ou configurar o JavaFX manualmente**. O Maven cuidará do download de todas as dependências automaticamente. A sua única preocupação será garantir que está utilizando uma versão do **JDK 21 ou superior** instalada e configurada no seu IntelliJ.

---

## 1. Atentando-se às Versões: Compatibilidade entre Java (JDK) e JavaFX

Para evitar erros de compilação, incompatibilidade de bibliotecas ou problemas no momento da execução, **a versão do JavaFX SDK deve ser equivalente ou compatível com a versão do Java (JDK) utilizada no projeto**.

### Regra Geral de Compatibilidade:
* A versão do JavaFX **deve bater com a versão principal do JDK** ou ser utilizada com um JDK da mesma geração.
* Versões **LTS** (Long-Term Support / Suporte de Longo Prazo) são as mais recomendadas para estudo, faculdade e projetos profissionais.

### Tabela de Referência:

| Versão da JDK (Java) | Versão do JavaFX SDK | Tipo / Recomendação                             |
| :--- | :--- |:------------------------------------------------|
| **JDK 21 ou superior** | **JavaFX 21** (ou superior) | **Recomendado** (LTS atual)                     |
| **JDK 17** | **JavaFX 17** | LTS anterior (muito usado em faculdades)        |
| **JDK 11** | **JavaFX 11** | LTS legada (Não recomendada)                    |
| **JDK 8** | *JavaFX integrado* | Nativo no próprio JDK (não requer SDK externo) (Não recomendada) |

---

## 2. Passo a Passo: Configuração Manual por Pasta (`lib`)

Este procedimento serve para **qualquer caso** (computadores com restrições de rede, laboratórios de faculdade, ambientes sem internet ou quando o download do Maven falhar por qualquer motivo).

### Passo 1: Baixar e Extrair o JavaFX SDK
1. Acesse o site oficial de distribuição do JavaFX: [gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)
2. Na seção de downloads, selecione a versão correspondente ao seu JDK (exemplo: **JavaFX 21** para **JDK 21**).
3. Escolha o seu Sistema Operacional (Windows, macOS ou Linux) e o tipo **SDK** (formato `.zip`).
4. Baixe e extraia a pasta compactada em um diretório do seu computador (exemplo: `C:\Java\javafx-sdk-21`).

---

### Passo 2: Criar o Projeto no IntelliJ
1. Abra o **IntelliJ IDEA Community Edition**.
2. Clique em **New Project**.
3. No painel esquerdo, selecione **JavaFX** (ou **Java**).
4. Configure as opções principais:
    * **Name:** Nome do seu projeto.
    * **Build system:** Selecione **Maven** (usado para organizar a estrutura do projeto e das pastas).
    * **JDK:** Selecione a sua versão do Java instalada (recomendada: JDK 21+).
5. Clique em **Create**.

---

### Passo 3: Adicionar a Pasta `lib` do JavaFX no Módulo do Projeto
Nesta etapa, o IntelliJ passará a reconhecer as classes do JavaFX diretamente dos arquivos `.jar` locais.

1. No menu superior do IntelliJ, vá em **File** > **Project Structure...** (ou use o atalho `Ctrl + Alt + Shift + S`).
2. No menu lateral esquerdo, clique em **Modules**.
3. Abra a aba **Dependencies** na parte superior da janela.
4. Clique no ícone de adição **`+`** (localizado no lado direito do painel) e escolha a opção **JARs or Directories...**
5. Navegue até o local onde você extraiu o JavaFX SDK e selecione a pasta **`lib`** (exemplo: `C:\Java\javafx-sdk-21\lib`).
6. Clique em **OK**.
7. Certifique-se de que a caixa ao lado da nova biblioteca adicionada esteja **marcada**.
8. Clique em **Apply** e em **OK**.

---

### Passo 4: Executar a Aplicação
Na maioria dos casos modernos, ao criar o projeto com a estrutura do Maven e vincular a pasta `lib`, a sua aplicação já estará pronta para rodar:

1. Abra a sua classe principal que estende `Application`.
2. Clique no ícone de **Play verde** ao lado do método `public static void main(...)` e selecione **Run 'SuaClasse.main()'**.
3. A janela gráfica do JavaFX será iniciada.

---

## 3. Observação: E se não funcionar de primeira? (Configuração de Argumentos de VM)

Caso você tente rodar o projeto e receba erros indicando que os componentes do JavaFX não foram encontrados (*"JavaFX runtime components are missing"*), será necessário informar explicitamente ao Java onde estão os módulos através das **VM Options**:

1. No canto superior direito do IntelliJ, ao lado do botão verde de Play, clique no menu suspenso de execução e selecione **Edit Configurations...**
2. Certifique-se de que a sua aplicação está selecionada no painel esquerdo.
3. Localize o campo **VM options**:
    * *Caso o campo não apareça:* Clique em **Modify options** (em azul) e marque a opção **Add VM options**.
4. No campo **VM options**, cole o seguinte comando (substituindo pelo caminho exato da sua pasta `lib`):

```bash
--module-path "C:/caminho/para/seu/javafx-sdk-21/lib" --add-modules javafx.controls,javafx.fxml