package com.example.projetoValdinei.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> getUsuarioByCpf(String cpf) {
        return usuariosRepository.findByCpf(cpf);
    }

    public Usuarios updateUsuario(String cpf, Usuarios usuarioDetails) {
        Usuarios usuario = usuariosRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Usuário não encontrado com CPF: " + cpf));
        usuario.setNome(usuarioDetails.getNome());
        usuario.setSobrenome(usuarioDetails.getSobrenome());
        usuario.setSenha(usuarioDetails.getSenha());
        return usuariosRepository.save(usuario);
    }

    public void deleteUsuario(String cpf) {
        Usuarios usuario = usuariosRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Usuário não encontrado com CPF: " + cpf));
        usuariosRepository.delete(usuario);
    }
}
