package com.example.pedidos.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Pedido {
    private String id;
    private String userId;
    private BigDecimal valor;
    private Instant criadoEm;

    public Pedido() {}

    public Pedido(String id, String userId, BigDecimal valor) {
        this.id = id;
        this.userId = userId;
        this.valor = valor;
        this.criadoEm = Instant.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Instant getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Instant criadoEm) { this.criadoEm = criadoEm; }
}
