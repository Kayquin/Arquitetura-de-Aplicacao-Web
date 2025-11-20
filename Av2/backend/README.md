# Sistema Acadêmico - Backend (Spring Boot 3)

Este repositório contém o backend do Sistema Acadêmico, implementado com Spring Boot 3.

Recursos principais
- Java 17
- Spring Boot 3
- Spring Data JPA (H2)
- Spring Security (HTTP Basic — configuração de exemplo)
- Spring Boot Actuator + Micrometer (Prometheus)
- Springdoc OpenAPI (Swagger UI)

Como executar localmente
1. Abra um terminal e vá para a pasta `backend`:

```powershell
cd C:\Users\...\...\Av2\backend
mvn spring-boot:run
```

2. A aplicação estará disponível em `http://localhost:8080`.
3. H2 Console (opcional): `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:academics`).

Endpoints úteis
- API base: `http://localhost:8080/api`
  - `GET /api/alunos` — listar alunos
  - `POST /api/alunos` — criar aluno
  - `POST /api/alunos/{alunoId}/cursos/{cursoId}` — associar aluno a curso
  - `GET /api/cursos` — listar cursos
  - `POST /api/cursos` — criar curso

- Swagger UI: `http://localhost:8080/swagger-ui.html` ou `http://localhost:8080/swagger-ui/index.html`
- Métricas Prometheus: `http://localhost:8080/actuator/prometheus`

Autenticação (ambiente de desenvolvimento)
- Usuário de exemplo: `user` / `password`
- Usuário admin: `admin` / `admin`
- Neste scaffold, os endpoints ` /api/**` exigem autenticação HTTP Basic. Endpoints do Actuator e Swagger estão liberados para facilitar testes.

Monitoramento com Prometheus e Grafana (local)
1. Verifique `prometheus.yml` e `docker-compose.yml` na pasta `backend`.
2. Inicie Prometheus e Grafana com Docker Compose:

```powershell
cd C:\Users\...\...\Av2\backend
docker compose up -d
```

3. No Prometheus (http://localhost:9090) confirme o target apontando para `host.docker.internal:8080`.
4. No Grafana (http://localhost:3000) crie uma datasource do tipo Prometheus apontando para `http://host.docker.internal:9090` (ou para `http://localhost:9090` dependendo da sua configuração Docker).

Testes de carga e stress
- Recomendo usar Gatling ou JMeter para simular múltiplos usuários e gerar relatórios (HTML/CSV). Colocar cenários de teste em `backend/load/` é uma boa prática.

Deployment
- Para deploy no Render, consulte: https://render.com/docs/deploy-spring. Ajuste variáveis de ambiente e configurações de segurança conforme necessário.

Próximos passos sugeridos
- Substituir HTTP Basic por JWT ou integrar com Keycloak para autenticação em produção.
- Adicionar testes unitários e de integração (JUnit + Spring Test).
- Adicionar scripts de carga (Gatling/JMeter) e documentação de execução.

Referências
- Spring Boot: https://docs.spring.io/spring-boot/docs/current/reference/html
- Spring Data JPA: https://docs.spring.io/spring-data/jpa/docs/current/reference/html
- Spring Security: https://docs.spring.io/spring-security/reference/index.html
- Springdoc OpenAPI: https://springdoc.org
- Prometheus: https://prometheus.io/docs
- Grafana: https://grafana.com/docs/grafana/latest
