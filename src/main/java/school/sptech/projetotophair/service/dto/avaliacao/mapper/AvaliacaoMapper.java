package school.sptech.projetotophair.service.dto.avaliacao.mapper;

import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.service.dto.avaliacao.AvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.empresa.mapper.EmpresaMapper;
import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;

public class AvaliacaoMapper {
    public static AvaliacaoResponseDto toAvaliacaoResponseDto(Avaliacao entity){
        AvaliacaoResponseDto dto = new AvaliacaoResponseDto();

        dto.setIdAvaliacao(entity.getIdAvaliacao());
        dto.setComentario(entity.getComentario());
        dto.setNivel(entity.getNivel());
        dto.setUsuario(UsuarioMapper.toUsuarioAvaliacaoResponseDto(entity.getUsuario()));
        dto.setEmpresaDto(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));

        return dto;
    }
}
