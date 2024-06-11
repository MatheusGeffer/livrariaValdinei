package com.example.projetoValdinei.emprestimos;

import com.example.projetoValdinei.livros.Livros;
import jakarta.persistence.*;

@Entity
public class Emprestimos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private Livros livros;

}
