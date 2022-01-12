###Nome do Projeto 

- Movie

###Descrição do Projeto

- API RestFull, possibilitar a leitura da lista de indicados e vencedores
da categoria Pior Filme do Golden Raspberry Awards.</p>

- Desenvolvido com framework mvc SpringBoot, para persistencia JPA, arquitetura hexagonal, banco de dados H2, Junit Teste de integração.</p>


###Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 11: Necessário para executar o projeto Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
- [Maven 4.0.0: Necessário para realizar o build do projeto Java](http://mirror.nbtelecom.com.br/apache/maven/maven-4/4.0.0/binaries/apache-maven-4.0.0-bin.zip)

###Construção

- mvn clean instal
- java -jar target/nome-jar

  O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. 

###Testes

   Para rodar os testes, utilize o comando abaixo:

- mvn test