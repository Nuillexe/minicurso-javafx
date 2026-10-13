# Manual de resolução de problemas

A maior parte dos problemas para a execução do projeto esta relacionada a compatibilidade da versão do Java e JavaFx

## JavaFx não reconhecido e precisa configurar manualmente 
Acesse o [Manual de configuração do JavaFx](Configuração%20Manual%20javaFx.md)

## Problemas com as configuraçoes do Java
Antes de executar o projeto, é necessarios verificar se em todas as configuraçoes a versão do java utilizada é 21+ e
compartivel com seu projeto. 

O ideal é que em diferentes configuraçoes seja considerado a mesma versão do Java

Um erro comum é aparecer no terminal que o projeto não é compativel com o Java 8 por exemplo, msm vc usando um Jdk 
diferente.


### Configuraçoes em Project Structure

![Selecionando Project Structure](/docs/images/img_1.png)

#### Module
Em Module deve-se atribuir a Language Level a numero da mesma vesão do jdk utilizada no projeto, no caso do nosso
projeto, 17+. O ideal é dexar prject Default, pq vai ser o msm numero do JDk utilizado

![Exemplo incorreto mantendo o Language Level mantendo-o em 8](/docs/images/img_2.png)
Versão não compativel com nosso projeto
![Exemplo selecionando 17](docs/images/img_3.png)
Versão correta

#### Project
Verificar se SDK e Language Level são 17+
![Configuração na aba de Project](/docs/images/img_6.png)

#### SDK's
Verifcar se há uma versão 17+ instalada
![Configuração na aba dos SDK's](/docs/images/img_7.png)

### Configuração em Settings
Vá em settings
![Settings](/docs/images/img_8.png)

Em seguida vá em **Build, Compiller, Execution** > **Compiller** > **Java Compiler**. Na tela que aparecer mude
*Project bytecode version* e *Target bytecode version* para 17+ ou Project Default.
![Tela da modificação em Settings](/docs/images/img_9.png)

Caso, durante a execução do projeto, apareça algum erro, feche a IDE, abra de novo, e refaça a modificação

