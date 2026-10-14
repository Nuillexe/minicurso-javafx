# Introdução ao JavaFX: Construindo uma Interface para Cadastro de Clientes

Este repositório contém o material prático e teórico do minicurso **"Introdução ao JavaFX: Construindo uma interface para cadastro de clientes"**, ministrado durante o **WeekIT**, evento integrante da Semana de Tecnologia do **IFBA — Campus Vitória da Conquista**.

O projeto é desenvolvido do zero utilizando a IDE **IntelliJ IDEA**.

---

## 📌 Pré-requisitos

Para acompanhar o minicurso e executar o projeto sem problemas, certifique-se de ter instalado:

* **JDK Java 21+** *(fortemente recomendado)* ou Java 17+.
* **Scene Builder** (para edição visual das telas `.fxml`).
* **IntelliJ IDEA** (Community ou Ultimate).

> ⚠️ **Observações Importantes:**
> * Nas versões mais recentes do IntelliJ IDEA, não é necessário configurar o SDK do JavaFX manualmente. Caso você esteja utilizando uma versão antiga da IDE ou precise configurar o JavaFX por fora, siga as orientações no [Manual de Configuração Manual do JavaFX](docs/Configuração%20Manual%20javaFx.md).
> * O **Java 21+** possui alta compatibilidade com as versões recentes do JavaFX. Caso opte pelo Java 17, certifique-se de utilizar a versão do JavaFX correspondente ao JDK 17.

---

## 🎯 Objetivos do Minicurso

O objetivo principal é introduzir os alunos ao ecossistema JavaFX de forma prática e estruturada. Durante o minicurso, abordaremos:

* **Construção de Interfaces Visuais**: Criação e edição de arquivos `.fxml` utilizando o Scene Builder.
* **Integração MVC**: Vinculação de elementos visuais e eventos de clique às suas respectivas classes *Controller*.
* **Gerenciamento de Navegação**: Troca de telas simples, limpa e reutilizável utilizando o `NavigationManager`.
* **Tratamento de Alertas**: Uso inteligente do `Alert` para exibições de erros e mensagens do sistema.

> 💡 *Devido ao tempo reduzido do evento, não abordaremos a estilização com arquivos CSS. No entanto, o conteúdo cobrirá todos os pilares essenciais para criar aplicações JavaFX funcionais e organizadas.*

---

## 📚 Documentação do Projeto

* 🗺️ **Roteiro do Minicurso**: Acompanhe o passo a passo da aula pelo [Roteiro Oficial](/docs/roteiro_do_minicurso.m).
* 🛠️ **Suporte e Solução de Erros**: Teve problemas de execução ou versão? Acesse o [Manual de Resolução de Problemas](/docs/Manual%20de%20resolucao%20de%20problemas.md).

---

## 🖥️ Demonstração da Aplicação

### 1. Tela de Menu
Interface principal onde o usuário pode optar por cadastrar novos clientes ou listar os já cadastrados na sessão.

![Tela de Menu](/docs/images/telaMenu.png)

### 2. Tela de Cadastro
Interface para inserção de dados do cliente (Nome, Idade e Telefone).
* **Validações**: Se o usuário deixar campos em branco ou digitar letras no campo numérico, o sistema emite um alerta de erro via `AlertManager` impedindo o cadastro incorreto.

![Tela de Cadastro](/docs/images/telaCadastro.png)
