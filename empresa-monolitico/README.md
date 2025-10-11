# empresa-monolitico

Projeto monolítico Spring Boot para gerenciamento de Funcionários e Departamentos.

## Como executar

1. Tenha Java 17 e Maven instalados.
2. Ajuste `src/main/resources/application.properties` com credenciais do MariaDB (ou rode com H2 ativando profile test).
3. Rodar:
```bash
mvn spring-boot:run
```
ou empacotar:
```bash
mvn package
java -jar target/empresa-monolitico-0.0.1-SNAPSHOT.jar
```

## Endpoints REST (exemplos curl)
- Listar departamentos:
```bash
curl http://localhost:8080/api/departamentos
```
- Criar departamento:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"nome":"RH","localizacao":"1º andar"}' http://localhost:8080/api/departamentos
```

## Observações
- Pacote base: `com.example.empresa`.
- Projeto pronto para abrir no IntelliJ/VS Code.
