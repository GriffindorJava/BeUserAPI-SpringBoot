package school.sptech.projetotophair.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.UsuarioService;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioLoginDto;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioAvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioCriacaoDto;
import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> criar(@RequestBody @Valid UsuarioCriacaoDto usuarioCriacaoDto) {
        this.usuarioService.criar(usuarioCriacaoDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@Valid @RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioTokenDto usuarioTokenDto = this.usuarioService.autenticar(usuarioLoginDto);
        return ResponseEntity.ok().body(usuarioTokenDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorid(@Valid @PathVariable Long id){
        Usuario usuario = this.usuarioService.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/avaliacao/{id}")
    public ResponseEntity<UsuarioAvaliacaoResponseDto> buscarPorIdAvaliacao(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorIdAvaliacao(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioAvaliacaoResponseDto usuarioAvaliacaoResponseDto = UsuarioMapper.toUsuarioAvaliacaoResponseDto(usuario);
        return ResponseEntity.ok(usuarioAvaliacaoResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, novoUsuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}