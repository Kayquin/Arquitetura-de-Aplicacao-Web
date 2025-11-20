# Hospedagem - Exemplo CRUD com Spring Boot

Projeto de exemplo que implementa um CRUD com relacionamento entre duas entidades: `Categoria` e `Documento`, usando Spring Boot, Spring Data JPA e documentação Swagger (springdoc).

**Links de apoio (vídeos):**
- http://youtube.com/watch?v=7x88AlD3Iv8
- https://www.youtube.com/watch?v=fwWvgk_SW2g

**Link da aplicação no Render (substitua pelo link real após deploy):**
- https://seu-projeto-render.onrender.com

**Link da documentação Swagger (substitua pelo link real):**
- https://seu-projeto-render.onrender.com/swagger-ui.html

## Tecnologias
- Java 17
- Spring Boot 2.7
- Spring Data JPA
- H2 (banco em memória para desenvolvimento)
- Springdoc OpenAPI (Swagger UI)

## Como executar localmente

Pré-requisitos: `Java 17` e `Maven`.

1. Clonar o repositório

```powershell
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

2. Executar com Maven

```powershell
mvn spring-boot:run
```

Ou empacotar e executar jar:

```powershell
mvn -DskipTests package
java -jar target/hospedagem-0.0.1-SNAPSHOT.jar
```

3. Acessos úteis
- API base: `http://localhost:8080/api`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## Endpoints principais

- `GET /api/categorias` - lista categorias
- `GET /api/categorias/{id}` - obtém categoria
- `POST /api/categorias` - cria categoria
- `PUT /api/categorias/{id}` - atualiza categoria
- `DELETE /api/categorias/{id}` - remove categoria

- `GET /api/documentos` - lista documentos
- `GET /api/documentos/{id}` - obtém documento
- `POST /api/documentos` - cria documento (json: `{ "titulo": "...", "conteudo": "...", "categoriaId": 1 }`)
- `PUT /api/documentos/{id}` - atualiza documento
- `DELETE /api/documentos/{id}` - remove documento

## Deploy no Render

1. Crie um repositório público no GitHub e faça push do código.
2. No Render, escolha "New" → "Web Service" e conecte ao repositório.
3. Configure as opções:
   - Build Command: `mvn -DskipTests package`
   - Start Command: `java -jar target/*.jar`
   - Environment: `Java` / `JVM` (Render detecta automaticamente)
4. Defina a variável de ambiente `PORT` (Render já fornece `PORT` automaticamente). O `application.properties` usa `server.port=${PORT:8080}`.
5. Após o deploy, acesse `https://<seu-servico>.onrender.com` e a documentação em `https://<seu-servico>.onrender.com/swagger-ui.html`.

## Documentação

O projeto usa `springdoc-openapi-ui`. A interface Swagger permite explorar e testar os endpoints.

Tutorial oficial do Swagger: https://swagger.io/docs/
