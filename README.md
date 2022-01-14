### Nome do Projeto 

- movie

### Descrição do Projeto

- API RestFull, possibilitar a leitura da lista de indicados e vencedores
da categoria Pior Filme do Golden Raspberry Awards.</p>

- Desenvolvido com framework mvc SpringBoot, Lombok,  para persistencia JPA, arquitetura hexagonal, banco de dados H2, Junit Teste de integração.</p>


### Para executar o projeto, será necessário instalar os seguintes programas:

- JDK 11: Necessário para executar o projeto Java
- Maven: Necessário para realizar o build do projeto 

### Construção

- mvn clean install
- java -jar target/movie-0.0.1-SNAPSHOT.jar

  O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. 
  
### Acesso Endpoint

- http://localhost:8080/movies/awards

  Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido

