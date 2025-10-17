# 🧩 Sistema CRUD com Testes Automatizados (Mockito + JMeter)

Este projeto é uma API RESTful desenvolvida em **Java com Spring Boot**, que implementa operações **CRUD completas** para a entidade `Product`.  
Além disso, inclui **testes unitários automatizados com Mockito** e um **plano de testes de desempenho com JMeter**.

---

## 📚 Sumário
- [Arquitetura](#arquitetura)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar a Aplicação](#como-executar-a-aplicação)
- [Endpoints Disponíveis](#endpoints-disponíveis)
- [Testes Automatizados (Mockito)](#testes-automatizados-mockito)
- [Testes de Desempenho (JMeter)](#testes-de-desempenho-jmeter)
- [Exemplos de Requisições](#exemplos-de-requisições)
- [Capturas de Relatórios](#capturas-de-relatórios)

---

## 🧱 Arquitetura
A aplicação segue o padrão em **camadas**:
```
Controller → Service → Repository → Database (H2)
```

Camadas principais:
- **Controller:** recebe as requisições HTTP.  
- **Service:** contém as regras de negócio.  
- **Repository:** realiza operações com o banco de dados.  
- **Entity:** define o modelo `Product`.

---

## ⚙️ Tecnologias Utilizadas
- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- H2 Database  
- Mockito & JUnit 5  
- Apache JMeter  
- Maven  

---

## ▶️ Como Executar a Aplicação

### 1️⃣ Clonar o Repositório
```bash
git clone https://github.com/SEU_USUARIO/crud-springboot-mockito-jmeter.git
cd crud-springboot-mockito-jmeter
```

### 2️⃣ Rodar a Aplicação
```bash
mvn spring-boot:run
```

A aplicação estará disponível em:  
👉 `http://localhost:8080/api/products`

### 3️⃣ Acessar o Console do H2
```
http://localhost:8080/h2-console
```
Use:
```
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha: (em branco)
```

---

## 🔗 Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| POST | `/api/products` | Cria um novo produto |
| GET | `/api/products` | Lista todos os produtos |
| GET | `/api/products/{id}` | Busca um produto pelo ID |
| PUT | `/api/products/{id}` | Atualiza um produto existente |
| DELETE | `/api/products/{id}` | Exclui um produto |

---

## 🧪 Testes Automatizados (Mockito)

### 📁 Localização:
```
src/test/java/com/example/crud/service/ProductServiceTest.java
```

### ▶️ Executar os testes
```bash
mvn test
```

Os testes cobrem:
- Criação de produtos (`createProduct`)
- Listagem de produtos (`getAllProducts`)
- Busca por ID (`getProductById`)
- Atualização (`updateProduct`)
- Exclusão (`deleteProduct`)

✅ Cobertura esperada: **~85% da camada de serviço**

---

## ⚡ Testes de Desempenho (JMeter)

### 📁 Arquivo de teste:
```
jmeter/test-plan.jmx
```

### Como rodar:
1. Abra o **Apache JMeter**  
2. Vá em **File → Open** e selecione o arquivo `test-plan.jmx`  
3. Configure o número de usuários simultâneos e a duração do teste  
4. Clique em **Start (Ctrl + R)**

### Relatórios disponíveis:
- **Summary Report:** visão geral com média de resposta, throughput e erros  
- **Aggregate Report:** estatísticas detalhadas por requisição  
- **View Results Tree:** mostra requisições e respostas individuais  
- **Graph Results (opcional):** gráfico de desempenho  

📊 Os relatórios podem ser exportados em CSV/HTML na pasta `jmeter/reports`.

---

## 💻 Exemplos de Requisições

### Criar Produto (POST)
```bash
curl -X POST http://localhost:8080/api/products      -H "Content-Type: application/json"      -d '{"name":"Notebook Dell","description":"i7 16GB RAM","price":5200.0,"quantity":5}'
```

### Listar Todos (GET)
```bash
curl http://localhost:8080/api/products
```

### Atualizar Produto (PUT)
```bash
curl -X PUT http://localhost:8080/api/products/1      -H "Content-Type: application/json"      -d '{"name":"Notebook Dell","description":"i9 32GB RAM","price":7800.0,"quantity":3}'
```

### Excluir Produto (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

---

## 📸 Capturas de Relatórios

**Resumo JMeter (Summary Report):**
```
Throughput: 450 req/s
Tempo médio: 180 ms
Erros: 0%
```

**Aggregate Report:**
```
Min: 120 ms | Max: 260 ms | Média: 180 ms | Desvio padrão: 30 ms
```

---

## 👨‍💻 Autor
**Kayque Avelar**  
💼 Suporte Ábax | 🚀 Desenvolvedor Java & Front-end  
📧 kayqueavelar@exemplo.com  

---

## 📝 Licença
Este projeto é distribuído sob a licença **MIT** — sinta-se à vontade para usar e modificar.
