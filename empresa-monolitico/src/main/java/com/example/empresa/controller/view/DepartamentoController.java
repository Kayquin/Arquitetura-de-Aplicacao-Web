package com.example.empresa.controller.view;

import com.example.empresa.model.Departamento;
import com.example.empresa.repository.DepartamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoRepository repo;

    public DepartamentoController(DepartamentoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("departamentos", repo.findAll());
        return "departamentos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "departamentos/form";
    }

    @PostMapping
    public String salvar(Departamento departamento) {
        repo.save(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("departamento", repo.findById(id).orElse(new Departamento()));
        return "departamentos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/departamentos";
    }
}
