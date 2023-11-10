package school.sptech.projetotophair.service.dto.servico.mapper;

import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.service.dto.servico.ServicoDto;

public class ServicoMapper {
    public static ServicoDto toServicoDto(Servico entity){
        ServicoDto dto = new ServicoDto();

        dto.setNomeServico(entity.getNomeServico());
        dto.setPreco(entity.getPreco());
        dto.setQtdTempoServico(entity.getQtdTempoServico());
        dto.setDescricao(entity.getDescricao());

        return dto;
    }
}
