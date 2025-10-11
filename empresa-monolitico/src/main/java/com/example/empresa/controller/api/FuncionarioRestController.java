package com.example.empresa.controller.api;

import com.example.empresa.model.Funcionario;
import com.example.empresa.repository.FuncionarioRepository;
import com.example.empresa.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioRestController {

    private final FuncionarioRepository repo;
    private final DepartamentoRepository deptRepo;

    public FuncionarioRestController(FuncionarioRepository repo, DepartamentoRepository deptRepo) {
        this.repo = repo;
        this.deptRepo = deptRepo;
    }

    @GetMapping
    public List<Funcionario> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario func) {
        if (func.getDepartamento() != null && func.getDepartamento().getId() != null) {
            func.setDepartamento(deptRepo.findById(func.getDepartamento().getId()).orElse(null));
        }
        return ResponseEntity.ok(repo.save(func));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario func) {
        return repo.findById(id)
                .map(ex -> {
                    ex.setNome(func.getNome());
                    ex.setEmail(func.getEmail());
                    ex.setDataAdmissao(func.getDataAdmissao());
                    ex.setDepartamento(func.getDepartamento());
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
