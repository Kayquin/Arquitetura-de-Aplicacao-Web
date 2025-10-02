package com.exemplo.universidade.service;

import com.exemplo.universidade.model.Aluno;
import com.exemplo.universidade.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listarTodos() { return repository.findAll(); }
    public Aluno buscarPorId(Long id) { return repository.findById(id).orElse(null); }
    public Aluno salvar(Aluno aluno) { return repository.save(aluno); }
    public Aluno atualizar(Long id, Aluno aluno) {
        Aluno existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(aluno.getNome());
            existente.setEmail(aluno.getEmail());
            existente.setDataNascimento(aluno.getDataNascimento());
            existente.setCurso(aluno.getCurso());
            return repository.save(existente);
        }
        return null;
    }
    public void deletar(Long id) { repository.deleteById(id); }
}
