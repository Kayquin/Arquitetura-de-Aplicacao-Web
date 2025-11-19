# Pedido Service — Monitoramento com Spring Boot, Prometheus e Grafana

Este repositório contém um exemplo de serviço `pedido-service` (Spring Boot) instrumentado com Micrometer, exposto ao Prometheus e visualizável no Grafana.

Requisitos
- Docker e Docker Compose
- JDK 17 / Maven

Como executar
1. Build e iniciar com Docker Compose:

   cd pedido-service
   docker compose up --build

Endpoints
- API: http://localhost:8080/pedidos (POST)
- Actuator Prometheus: http://localhost:8080/actuator/prometheus
- Prometheus UI: http://localhost:9090
- Grafana: http://localhost:3000 (admin/admin)

Exemplo de criação de pedido:

curl -X POST http://localhost:8080/pedidos -H "Content-Type: application/json" -d '{"userId":"user-1","valor":123.45}'

