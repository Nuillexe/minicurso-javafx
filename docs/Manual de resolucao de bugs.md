# Manual de Resolução de Problemas

A maior parte dos problemas durante a execução de projetos JavaFX está relacionada a conflitos entre as versões do Java e das bibliotecas.

> ⚠️ **ATENÇÃO À VERSÃO DO JAVA:**
> Recomendamos fortemente o uso do **Java 21**. Versões anteriores (como o Java 17 ou Java 8) costumam apresentar incompatibilidades complexas com as versões mais recentes do JavaFX.

---

## 1. JavaFX não reconhecido no projeto
Se o JavaFX não estiver sendo reconhecido ou a IDE acusar falta de módulos na execução, consulte o guia passo a passo no [Manual de Configuração Manual do JavaFX](Configuração%20Manual%20javaFx.md).

---

## 2. Incompatibilidade de Versões do Java (Erros de Bytecode / Class Version)

Um erro muito comum no terminal ao tentar rodar a aplicação é:  
`java.lang.UnsupportedClassVersionError: ... has been compiled by a more recent version of the Java Runtime`  
Ou mensagens indicando incompatibilidade com versões antigas (como Java 8), mesmo quando você tem um JDK mais novo instalado.

Para resolver isso, precisamos padronizar **todas** as configurações da IDE para utilizarem o **Java 21**.

---

### Passo 1: Ajustar a Estrutura do Projeto (*Project Structure*)

Abra a janela de estrutura do projeto pelo atalho **`Ctrl + Alt + Shift + S`** (Windows/Linux) ou **`Cmd + ;`** (Mac), ou acesse pelo menu:  
`File` ➔ `Project Structure...`

Siga as verificações abaixo no menu lateral esquerdo:

#### A. Aba **Project**
1. No campo **SDK**, selecione o **Java 21** (ou JDK 21).
2. No campo **Language level**, escolha **21 - Preview - Pattern matching for switch...** (ou `Project Default`).

#### B. Aba **Modules**
1. Clique no seu projeto na lista de módulos.
2. Na aba **Sources**, verifique o campo **Language level**.
3. Altere de *8* ou *17* para **`Project Default (21 - ...)`** ou escolha diretamente o nível **21**.

#### C. Aba **SDKs**
1. Confirme se o **JDK 21** está listado na barra lateral.
2. Caso não esteja, clique no botão **`+` (Add New SDK)** ➔ **Download JDK** ➔ Selecione a versão **21** (Vendor: Oracle ou Eclipse Temurin) para instalar automaticamente.

---

### Passo 2: Ajustar as Configurações do Compilador (*Settings*)

Abra as configurações da IDE pelo atalho **`Ctrl + Alt + S`** (Windows/Linux) ou **`Cmd + ,`** (Mac), ou acesse:  
`File` ➔ `Settings` (ou `Preferences`).

Navegue pelo menu lateral:  
`Build, Execution, Deployment` ➔ `Compiler` ➔ `Java Compiler`

Faça os seguintes ajustes:

1. **Project bytecode version**: Mude para **21** (ou `Project Default`).
2. **Target bytecode version** (na tabela abaixo, se listada): Certifique-se de que a coluna da versão esteja em **21**.

---

### 💡 Dica de Ouro (Reiniciar a IDE)
Se mesmo após alterar todas essas opções o erro continuar aparecendo:
1. Vá em `File` ➔ `Invalidate Caches...`
2. Marque as opções e clique em **Invalidate and Restart**.
3. Abra a IDE novamente e rode a classe `Launcher.java`.