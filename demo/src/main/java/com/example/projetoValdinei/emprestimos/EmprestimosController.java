package com.example.projetoValdinei.emprestimos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimosController {

    @Autowired
    private EmprestimosService emprestimosService;

    @GetMapping
    public List<Emprestimos> findAll() {
        return emprestimosService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Emprestimos> findById(@PathVariable Long id) {
        return emprestimosService.findById(id);
    }

    @PostMapping
    public Emprestimos save(@RequestBody Emprestimos emprestimo) {
        return emprestimosService.save(emprestimo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        emprestimosService.deleteById(id);
    }
}
