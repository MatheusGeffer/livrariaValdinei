package com.example.projetoValdinei.emprestimos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimosService {

    @Autowired
    private EmprestimosRepository emprestimosRepository;

    public List<Emprestimos> findAll() {
        return emprestimosRepository.findAll();
    }

    public Optional<Emprestimos> findById(Long id) {
        return emprestimosRepository.findById(id);
    }

    public Emprestimos save(Emprestimos emprestimo) {
        return emprestimosRepository.save(emprestimo);
    }

    public void deleteById(Long id) {
        emprestimosRepository.deleteById(id);
    }
}
