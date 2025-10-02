package com.exemplo.universidade.controller;

import com.exemplo.universidade.model.Curso;
import com.exemplo.universidade.service.CursoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Curso> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @PostMapping
    public Curso criar(@RequestBody Curso curso) { return service.salvar(curso); }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @RequestBody Curso curso) { return service.atualizar(id, curso); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }
}
