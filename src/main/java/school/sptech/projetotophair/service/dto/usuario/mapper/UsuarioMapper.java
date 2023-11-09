package school.sptech.projetotophair.service.dto.usuario.mapper;

import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioAvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioCriacaoDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioResponseDto;

public class UsuarioMapper {

    public static UsuarioAvaliacaoResponseDto toUsuarioAvaliacaoResponseDto(Usuario entity){
        UsuarioAvaliacaoResponseDto dto = new UsuarioAvaliacaoResponseDto();

        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNomeCompleto(entity.getNomeCompleto());
        dto.setEmail(entity.getEmail());
        dto.setCpf(entity.getCpf());
        dto.setTelefone(entity.getTelefone());
        dto.setIsProfissional(entity.getProfissional());

        return dto;
    }

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

    public static UsuarioResponseDto toUsuarioResponseDto(Usuario entity){
        UsuarioResponseDto dto = new UsuarioResponseDto();

        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNomeCompleto(entity.getNomeCompleto());
        dto.setEmail(entity.getEmail());
        dto.setCpf(entity.getCpf());
        dto.setTelefone(entity.getTelefone());

        return dto;
    }
}
