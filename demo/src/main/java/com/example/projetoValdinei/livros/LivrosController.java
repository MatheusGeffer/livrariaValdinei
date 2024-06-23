package com.example.projetoValdinei.livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @GetMapping
    public List<Livros> findAll() {
        return livrosService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Livros> findById(@PathVariable Long id) {
        return livrosService.findById(id);
    }

    @PostMapping
    public Livros save(@RequestBody Livros livro) {
        return livrosService.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        livrosService.deleteById(id);
    }
}
