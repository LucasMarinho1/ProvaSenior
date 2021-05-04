# Api de Propaganda (PROVA NIVEL II)
Trata-se de um Api para cadastro de produtos/servicos, alem de permitir o cadastro de pedidos destes produtos/servicos.


## Executar/Compilar

**Utilizados**
- IDE: eclipse (2020-06 (4.16.0) + Spring tools 4
- Sistema Operacional Windows 10
- Git (2.27.0.windows.1)
- Spring Boot (2.3.1.RELEASE)
- Java (1.8)
- Datatables (1.10.19)
- Banco de dados PostgreSQL

**Compilar**

clone o projeto para seu local e execute o comando.

```
mvn package exec:java
```
## Executar Aplicação 

O arquivo de importação do postman se encontra na raiz para facilitar a utilização.

## Banco de dados
Estrutura do banco de dados:

![Untitled](https://user-images.githubusercontent.com/34521024/117032576-f7c8a500-acd7-11eb-8404-49d7def750b5.png)


**Restaurar Beckup Banco de dados**

Caso queiram poderam importar a base de dados que utilizei para facilitar.

```
C:\Program Files\PostgreSQL\13\bin\pg_dump.exe --file "{caminho da base}" --host "localhost" --port "5432" --username "postgres" --no-password --verbose --format=c --blobs "provaSenior"
```

OBS: backup do banco esta na raiz do projeto.

## Documentação no swagger

para acessar --> http://localhost:8080/swagger-ui.html

## links úteis
 
 Acessar Banco de dado PostgreSQL, lembrando que sera necessario voces alterarem a sua configuracao em **application.properties**.


- spring.datasource.url=**jdbc:postgresql://localhost:5432/provaSenior**
- spring.datasource.username=**postgres**
- spring.datasource.password=**admin**


Acessar Swagger - documentacao

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
