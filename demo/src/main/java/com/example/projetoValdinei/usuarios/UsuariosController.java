package com.example.projetoValdinei.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuarios> getUsuarioByCpf(@PathVariable String cpf) {
        Usuarios usuario = usuariosService.getUsuarioByCpf(cpf).orElseThrow(() -> new RuntimeException("Usuário não encontrado com CPF: " + cpf));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable String cpf, @RequestBody Usuarios usuarioDetails) {
        Usuarios updatedUsuario = usuariosService.updateUsuario(cpf, usuarioDetails);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String cpf) {
        usuariosService.deleteUsuario(cpf);
        return ResponseEntity.noContent().build();
    }
}
