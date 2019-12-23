# rrlabs-customer

## Microservice de exemplo representando o dominio de cliente.

### A ideia principal é um cadastro simples de cliente utilizando banco NOSql Cassandra__

### Existe 4 Principais APIs:__
- GET: /customer
- POST: /customer
- PUT: /customer
- GET: /customer/{id}

Para acessar o swagger que possui os detalhes de cada API, basta acessar o link após o start da aplicação:
<a href="http://localhost:8080/swagger-ui.html">Swagger-UI</a>

Para facilitar a utilização do cassandra, vamos utilizar uma imagem docker que contenha o cassandra e mapear o acesso ao volume e porta.

    docker run -it --name cassandra -v /home/app/db/cassandra:/var/lib/cassandra -d cassandra -p 9042:9042

Onde o caminho: "/home/app/db/cassandra" é o diretorio local mapeado como volume.

Para visualizar o codigo da API, acesse a seguinte classe: 
    
    rr.labs.customer.controller.CustomerController     


