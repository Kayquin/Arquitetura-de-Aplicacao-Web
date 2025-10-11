package com.example.empresa.controller.api;

import com.example.empresa.model.Departamento;
import com.example.empresa.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {

    private final DepartamentoRepository repo;

    public DepartamentoRestController(DepartamentoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Departamento> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departamento criar(@RequestBody Departamento d) {
        return repo.save(d);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizar(@PathVariable Long id, @RequestBody Departamento dep) {
        return repo.findById(id)
                .map(ex -> {
                    ex.setNome(dep.getNome());
                    ex.setLocalizacao(dep.getLocalizacao());
                    return ResponseEntity.ok(repo.save(ex));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
