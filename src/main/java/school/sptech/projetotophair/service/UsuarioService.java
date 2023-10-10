package school.sptech.projetotophair.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.api.configuration.security.jwt.GerenciadorTokenJwt;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioLoginDto;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.UsuarioCriacaoDto;
import school.sptech.projetotophair.service.dto.UsuarioMapper;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;
    @Autowired
    private AuthenticationManager authenticationManager;

    public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
        if (usuarioRepository.existsByEmail(usuarioCriacaoDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);

        String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
        novoUsuario.setSenha(senhaCriptografada);

        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado =
                usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                        .orElseThrow(
                                () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioMapper.of(usuarioAutenticado, token);
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado com ID: " + id)
        );
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, Usuario novoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + id));

        usuarioExistente.setNomeCompleto(novoUsuario.getNomeCompleto());
        usuarioExistente.setEmail(novoUsuario.getEmail());
        usuarioExistente.setTelefone(novoUsuario.getTelefone());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + id));

        usuarioRepository.delete(usuario);
    }
}
