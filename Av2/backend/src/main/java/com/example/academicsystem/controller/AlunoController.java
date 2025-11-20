package com.example.academicsystem.controller;

import com.example.academicsystem.model.Aluno;
import com.example.academicsystem.model.Curso;
import com.example.academicsystem.repository.AlunoRepository;
import com.example.academicsystem.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoController(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Aluno> list() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno saved = alunoRepository.save(aluno);
        return ResponseEntity.created(URI.create("/api/alunos/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> get(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno in) {
        Optional<Aluno> existing = alunoRepository.findById(id);
        if (existing.isEmpty()) return ResponseEntity.notFound().build();
        Aluno a = existing.get();
        a.setNome(in.getNome());
        a.setEmail(in.getEmail());
        a.setMatricula(in.getMatricula());
        alunoRepository.save(a);
        return ResponseEntity.ok(a);
    }

    @PostMapping("/{alunoId}/cursos/{cursoId}")
    public ResponseEntity<?> addCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoId);
        Optional<Curso> optionalCurso = cursoRepository.findById(cursoId);
        if (optionalAluno.isEmpty() || optionalCurso.isEmpty()) return ResponseEntity.notFound().build();
        Aluno aluno = optionalAluno.get();
        Curso curso = optionalCurso.get();
        aluno.addCurso(curso);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
    }
}
