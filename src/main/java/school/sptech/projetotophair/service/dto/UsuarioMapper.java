package school.sptech.projetotophair.service.dto;

import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;

public class UsuarioMapper {
    public static Usuario of(UsuarioCriacaoDto usuarioCriacaoDto) {
        Usuario usuario = new Usuario();

        usuario.setEmail(usuarioCriacaoDto.getEmail());
        usuario.setCpf(usuarioCriacaoDto.getCpf());
        usuario.setNomeCompleto(usuarioCriacaoDto.getNomeCompleto());
        usuario.setSenha(usuarioCriacaoDto.getSenha());
        usuario.setProfissional(usuarioCriacaoDto.getProfissional());

        return usuario;
    }

    public static UsuarioTokenDto of(Usuario usuario, String token) {
        UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();

        usuarioTokenDto.setUserId(usuario.getIdUsuario());
        usuarioTokenDto.setEmail(usuario.getEmail());
        usuarioTokenDto.setNomeCompleto(usuario.getNomeCompleto());
        usuarioTokenDto.setToken(token);

        return usuarioTokenDto;
    }
}
