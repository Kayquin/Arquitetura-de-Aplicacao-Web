# API REST - Alunos e Cursos

## 📌 Descrição
API RESTful desenvolvida em Spring Boot com persistência em MariaDB para gerenciar **Alunos** e **Cursos** com operações CRUD completas.

## 🚀 Tecnologias
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MariaDB
- Lombok

## ⚙️ Configuração
Edite o arquivo `src/main/resources/application.properties` com seu usuário e senha do MariaDB.

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/universidade
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## ▶️ Executando
```bash
./mvnw spring-boot:run
```

## 📚 Endpoints
### Cursos
- `POST /cursos`
- `GET /cursos`
- `GET /cursos/{id}`
- `PUT /cursos/{id}`
- `DELETE /cursos/{id}`

### Alunos
- `POST /alunos`
- `GET /alunos`
- `GET /alunos/{id}`
- `PUT /alunos/{id}`
- `DELETE /alunos/{id}`
