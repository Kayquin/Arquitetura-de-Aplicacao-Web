package com.exemplo.universidade.controller;

import com.exemplo.universidade.model.Aluno;
import com.exemplo.universidade.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) { return service.buscarPorId(id); }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) { return service.salvar(aluno); }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) { return service.atualizar(id, aluno); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }
}
