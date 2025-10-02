package com.exemplo.apitarefas.service;

import com.exemplo.apitarefas.model.Tarefa;
import com.exemplo.apitarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa criar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public Optional<Tarefa> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Tarefa atualizar(String id, Tarefa tarefaAtualizada) {
        return repository.findById(id).map(t -> {
            t.setTitulo(tarefaAtualizada.getTitulo());
            t.setDescricao(tarefaAtualizada.getDescricao());
            t.setDataConclusao(tarefaAtualizada.getDataConclusao());
            t.setStatus(tarefaAtualizada.getStatus());
            return repository.save(t);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada: " + id));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}
