package com.example.pedidos.service;

import com.example.pedidos.model.Pedido;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Service
public class PedidoService {

    private final Counter pedidosCriados;
    private final DistributionSummary valorPedidos;
    private final Timer processamentoTimer;
    private final Random random = new Random();

    public PedidoService(MeterRegistry registry) {
        this.pedidosCriados = Counter.builder("pedidos_criados_count")
                .description("Quantidade de pedidos criados")
                .register(registry);
        this.valorPedidos = DistributionSummary.builder("pedidos_valor")
                .description("Distribuição dos valores dos pedidos")
                .baseUnit("BRL")
                .register(registry);
        this.processamentoTimer = Timer.builder("pedidos_processamento_timer")
                .description("Tempo de processamento de pedidos")
                .publishPercentiles(0.5, 0.9, 0.99)
                .register(registry);
    }

    public Pedido criarPedido(String userId, BigDecimal valor) {
        String id = UUID.randomUUID().toString();
        MDC.put("pedidoId", id);
        MDC.put("userId", userId);
        try {
            return processamentoTimer.record(() -> {
                try {
                    int delay = 100 + random.nextInt(900);
                    Thread.sleep(delay);
                    if (random.nextDouble() < 0.05) {
                        throw new RuntimeException("Erro ao processar pedido");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                pedidosCriados.increment();
                valorPedidos.record(valor.doubleValue());
                return new Pedido(id, userId, valor);
            });
        } finally {
            MDC.remove("pedidoId");
            MDC.remove("userId");
        }
    }
}
