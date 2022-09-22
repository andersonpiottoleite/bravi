
* Projeto Desenvolvido usando SpringBoot (2.7.3), Java 18 e a IDE: Intellj IDEA.


* Tanto a funcionalidade de cadastrar pessoas e contatos, quanto a funcionalidade de validar a ordem dos colchetes,
  quanto a parte de validação do clima or cidade, por questões de pratica nos testes, estão nessa mesma API.


* Para todas as atividades foi desenvolvido a parte de Back-end.


* Repositório GIT:
  https://github.com/andersonpiottoleite/bravi.git


* Para rodar o projeto:
- 1 - Fazer o clone do projeto, uma opção é usar o comando "git clone https://github.com/andersonpiottoleite/bravi.git" (isso pode ser feito pelo GitBash)
- 2 - No diretório onde for feito o cloent, rodar o comando "mvn install" ou "mvn package", para gerar o artefato .jar
- 3 - Confira se o artefato foi gerado na pasta target do projeto.
- 4 - Dentro da pasta target (use o comando "cd target" para entrar na pasta) execute o comando "java -jar Teste-Bravi-0.0.1-SNAPSHOT.jar"

* Após rodar o projeto, os endpoints podem ser acionados pela interface do Swagger:

* Swagger:
  http://localhost:8080/teste-bravi/swagger-ui.html#


* Os dados persistidos podem ser consultado (via SQL) na seguinte interface do H2:
* H2:
  http://localhost:8080/teste-bravi/h2
  login:sa
  passoword:sa


Para encerrar o projeto, execute o seguinte comando no GitBash:
control + c 