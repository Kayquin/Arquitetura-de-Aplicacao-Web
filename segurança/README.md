# Demo: Spring Boot + JWT (Keycloak)

Projeto de exemplo que demonstra como proteger uma API Spring Boot usando JWT emitido pelo Keycloak.

## Requisitos
- Java 17+
- Maven
- Keycloak (localmente, ex.: versão 21+)
- Postman ou `curl` para testes

## Estrutura

- `src/main/java/com/exemplo/demo` - código-fonte
- `src/main/resources/application.yml` - configuração (issuer-uri do Keycloak)

## Configurar o Keycloak (resumo rápido)

1. Inicie o Keycloak localmente (ex.: imagem Docker ou distribuição local).
2. Crie um Realm chamado `demo`.
3. Crie um Client chamado `spring-api` com:
   - Access Type: `confidential`
   - Standard Flow Enabled: `true`
   - Direct Access Grants Enabled: `true` (para o grant_type=password)
4. No Client, copie o `client secret` (precisa para exemplos usando client credentials ou password).
5. Crie roles no Realm: `user`, `admin`.
6. Crie usuários e atribua as roles apropriadas.
7. Anote o issuer-uri: `http://localhost:8080/realms/demo`

## Como rodar a aplicação

Compile e execute com Maven:

```powershell
mvn clean package
mvn spring-boot:run
```

Ou rode o JAR:

```powershell
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Endpoints

- `GET /public` — público
- `GET /user` — requer autenticação
- `GET /admin` — requer role `admin`

## Obter um token JWT (exemplo usando password grant)

Substitua `CLIENT_ID`, `CLIENT_SECRET`, `USERNAME`, `PASSWORD` pelos valores do seu Keycloak.

```bash
curl -X POST "http://localhost:8080/realms/demo/protocol/openid-connect/token" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "grant_type=password&client_id=CLIENT_ID&client_secret=CLIENT_SECRET&username=USERNAME&password=PASSWORD"
```

Resposta: JSON com `access_token` — use esse token nas requisições.

## Testar endpoints

Exemplo com `curl`:

```bash
curl -H "Authorization: Bearer <ACCESS_TOKEN>" http://localhost:8080/user
curl -H "Authorization: Bearer <ACCESS_TOKEN>" http://localhost:8080/admin
```

`/public` pode ser acessado sem token:

```bash
curl http://localhost:8080/public
```

## Observações de segurança

- O `SecurityConfig` mapeia roles do claim `realm_access.roles` para `ROLE_<role>` no Spring Security.
- Ajuste `application.yml` com a URL do issuer correta em produção (HTTPS obrigatório).

## Material de apoio

- O que você deveria saber sobre Oauth 2.0 e OpenID: https://www.youtube.com/watch?v=68azMcqPpyo
- OAuth Client Credentials com Java, Spring Boot e Keycloak: https://www.youtube.com/watch?v=BoPLhhIN9ks
- Tutorial Spring Authorization Server + OpenID: https://www.youtube.com/watch?v=hgLKOPHfuis
- OAuth + OpenID com Spring Security e Keycloak: https://www.youtube.com/watch?v=vV2NdanynpA
