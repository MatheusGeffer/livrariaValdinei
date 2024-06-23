package com.example.projetoValdinei.livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livros> findAll() {
        return livrosRepository.findAll();
    }

    public Optional<Livros> findById(Long id) {
        return livrosRepository.findById(id);
    }

    public Livros save(Livros livro) {
        return livrosRepository.save(livro);
    }

    public void deleteById(Long id) {
        livrosRepository.deleteById(id);
    }
}
