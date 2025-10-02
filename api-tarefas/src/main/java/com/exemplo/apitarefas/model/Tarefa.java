package com.exemplo.apitarefas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Document(collection = "tarefas")
public class Tarefa {

    @Id
    private String id;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private Status status;

    public Tarefa() {
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.PENDENTE;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public LocalDateTime getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDateTime dataConclusao) { this.dataConclusao = dataConclusao; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
