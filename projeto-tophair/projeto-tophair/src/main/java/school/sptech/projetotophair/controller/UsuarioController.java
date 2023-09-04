package school.sptech.projetotophair.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            return ResponseEntity.status(200).body(usuarios.get(indice));
        } else if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int indice, @RequestBody Usuario usuarioAtualizado) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.set(indice, usuarioAtualizado);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/{indice}/verificar-profissional")
    public ResponseEntity<Boolean> verificarUsuarioProfissional(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            return ResponseEntity.status(200).body(usuarios.get(indice).getProfissional());
        } else if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}