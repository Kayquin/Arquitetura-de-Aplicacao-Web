package com.example.academicsystem.controller;

import com.example.academicsystem.model.Curso;
import com.example.academicsystem.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Curso> list() {
        return cursoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        Curso saved = cursoRepository.save(curso);
        return ResponseEntity.created(URI.create("/api/cursos/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> get(@PathVariable Long id) {
        return cursoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
