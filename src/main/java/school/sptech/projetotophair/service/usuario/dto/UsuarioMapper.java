package school.sptech.projetotophair.service.usuario.dto;

import school.sptech.projetotophair.domain.usuario.Usuario;

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
}
