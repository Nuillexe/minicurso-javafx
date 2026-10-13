# Roteiro do Minicurso

## Indice
- [Etapa 1: Apesentação do JavaFx e criando u projeto](#1-etapa-apresetação-do-javafx-e-criando-um-projeto)
- [Etapa 2: Verificar bugs](#2-etapa-verificar-bugs-)
- []


## 1° Etapa: Apresetação do JavaFx e criando um projeto
O javaFx é um framework de Java que permite criar aplicativos desktop. 
a inteface grafica através de arquivos FXML que são nossas telas propriamente ditas. Assim com HTML, FXML 
também é um tipo de linguagem de marcação, inclusive essa também pode ser estilizada com CSS 

Na pasta resources tem a finalidade de armazenar todos os recursos gráficos(arquivos FXML, CSS, e imagens) do nosso 
projeto.

Mas então como dexar nossas telas interativas? Todo o código Java da nossa aplicação ficará no package src. 
Nesse package deve ter um arquivo/classe correspondente pra cada tela, chamados de Controllers. Neles são processados 
eventos e dados inseridos nas telas. Funcionam de forma semelhante ao Java Script em relação ao HTML.

E como rodamos o projeto. Pra rodar o projeto é necessario ter uma classe que herde a classe Aplication e inicialize o 
a aplicação.

O JavaFx ele se baseia no padrão de arquitetura Model, View, Controller
- **Model**: Faz referencia ao pacote de dodos correspondente a classe das entidades dos sistemas, neste minicurso, classe 
Cliente
- **View**: Diz respeito a toda parte visual e de interação com o Usuario, representado pelos arquivos FXML
- **Controller**: Representa os recursos utilizados para controlar o fluxo da Aplicação. No ambiente d nosso curso, são 
representados polas classes que fazem parte do package Controllers


- **Criando um novo projeto**: Na tela de new Project:, 
  - clique em JavaFx, 
  - escreva o nome do projeto, Interface de cadastro de clientes
  - coloque aonde ele será salvo 
  - selecione a linguagem java
  - selcione o Build System, no nosso caso será o Maven. Também chamado de
organizador  dependencias, ele organizará os arquivos e dependencias do seu projeto
  - Nome do Artifact. O Artifact é o nome do executavel do projeto

## 2° Etapa: Verificar bugs:
Automaticamente quando se cria um projeto JavaFx, é gerado a aplicação 
HelloAplication, uma especie de "Hello Word". Para testar se ta tudo configurado, 
clique em *Run*.Se aparecer a tela com "Hello" esta tudo ok, se não, de uma olha 
no [Manual de resolução de problemas](/docs/Manual%20de%20resolucao%20de%20bugs.md).

## 3° Etapa: Criação dos packages/pastas e classes 
O Projeto será organizado nos seguintes pacotes
- Controllers: com as classes [MenuController](/src/main/java/com/example/interface_de_clientes/Controllers/MenuController.java) e [CadastroController](/src/main/java/com/example/interface_de_clientes/Controllers/CadastroController.java)
- Models: composta somente pela classe [Cliente](/src/main/java/com/example/interface_de_clientes/Models/Cliente.java)
- Utils: Aqui é implementado ferramentas que facilitarão o desenvolvimento do projeto. Ela será compostas por:
  - [NavigationManager](/src/main/java/com/example/interface_de_clientes/Utills/NavigationManager.java) 
  composta por ferramentas de Navegação
  - [AlertManager](/src/main/java/com/example/interface_de_clientes/Utills/AlertManager.java) que conterá ferramentas 
  para facilitar o uso dos Alerts

#### Classes Launcher.java e Main.java
A classe [Launcher](/src/main/java/com/example/interface_de_clientes/Launcher.java) e responsavel por inicializar o 
projeto chamando a classe [Main](/src/main/java/com/example/interface_de_clientes/Main.java). Essa irá carregar a tela 
inicial do projeto. Divide-se assim para que n exista nenhuma perda de dados durante a inicilização. 

Após a inicialização, as trocas de tela serão feitas com o suporte de [NavigationManager](/src/main/java/com/example/interface_de_clientes/Utills/NavigationManager.java)

#### Classe Sessão
A classe [Sessão](/src/main/java/com/example/interface_de_clientes/Sessao.java) tem como finalidade armazenar os dados 
de navegação. Esses dados não necessariamente precisam ser persistidos, no entanto, são informaçoes que podem ser 
requisitados por diferentes telas e é importante acessalos de forma pratica

## 4° Construindo as telas com o SceneBuilder
- Crie os arquivos Fxml para a telas de [Menu](/src/main/resources/com/example/interface_de_clientes/menu.fxml) e 
[Cadastro de Clientes](/src/main/resources/com/example/interface_de_clientes/cadastro.fxml)
- **Abra eles no SceneBuilder**: Clique em cima deles com o botão direito e selecione a opção *Open in SceneBuilder*. Na
primeira vez, o InteliJ vai pedir para vc selecionar onde esta o SceneBuilder
[Abrindo o FXML com o SceneBuilder](/docs/images/img_10.png); 
### Construindo a tela de Menu:  
  - Pesquise na aba de pesquisa por "Label", e obterá um campo de texto, um *Label* 
  - Clique no Label, vá em Properties, no campo Text, e escreva Menu pra dar um texto ao Label
  - Pesquise na aba de pesquisa por *Button*, e obterá um Botão. Em um, na aba de Propertyes, no campo text, digite 
"Cadastrar novo Cliente". No outro repita o processo, mas digite "Ver Clientes" em Text
  - No Botão de VerClientes, na aba Code, procure por

### Construindo a tela de Cadastro


