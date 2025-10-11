package com.example.empresa.controller.view;

import com.example.empresa.model.Funcionario;
import com.example.empresa.repository.FuncionarioRepository;
import com.example.empresa.repository.DepartamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository repo;
    private final DepartamentoRepository deptRepo;

    public FuncionarioController(FuncionarioRepository repo, DepartamentoRepository deptRepo) {
        this.repo = repo;
        this.deptRepo = deptRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", repo.findAll());
        return "funcionarios/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("departamentos", deptRepo.findAll());
        return "funcionarios/form";
    }

    @PostMapping
    public String salvar(Funcionario funcionario) {
        repo.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("funcionario", repo.findById(id).orElse(new Funcionario()));
        model.addAttribute("departamentos", deptRepo.findAll());
        return "funcionarios/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/funcionarios";
    }
}
