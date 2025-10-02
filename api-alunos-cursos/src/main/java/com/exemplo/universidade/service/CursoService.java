package com.exemplo.universidade.service;

import com.exemplo.universidade.model.Curso;
import com.exemplo.universidade.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listarTodos() { return repository.findAll(); }
    public Curso buscarPorId(Long id) { return repository.findById(id).orElse(null); }
    public Curso salvar(Curso curso) { return repository.save(curso); }
    public Curso atualizar(Long id, Curso curso) {
        Curso existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(curso.getNome());
            existente.setCargaHoraria(curso.getCargaHoraria());
            return repository.save(existente);
        }
        return null;
    }
    public void deletar(Long id) { repository.deleteById(id); }
}
