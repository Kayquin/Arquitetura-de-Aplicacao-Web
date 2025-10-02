# API REST - Gerenciamento de Tarefas

API simples para gerenciar tarefas utilizando Spring Boot e MongoDB.

## Requisitos
- Java 17+
- Maven
- MongoDB rodando (localhost:27017)

## Como rodar
```bash
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Endpoints
- GET /tarefas
- GET /tarefas/{id}
- POST /tarefas
- PUT /tarefas/{id}
- DELETE /tarefas/{id}
