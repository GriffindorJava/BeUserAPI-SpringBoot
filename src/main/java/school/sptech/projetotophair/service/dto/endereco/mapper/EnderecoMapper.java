package school.sptech.projetotophair.service.dto.endereco.mapper;

import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.service.dto.endereco.EnderecoDto;

public class EnderecoMapper {
    public static EnderecoDto toEnderecoDto(Endereco entity){
        EnderecoDto dto = new EnderecoDto();

        dto.setCep(entity.getCep());
        dto.setNumero(entity.getNumero());
        dto.setEstado(entity.getEstado());
        dto.setCidade(entity.getCidade());
        dto.setComplemento(entity.getComplemento());
        dto.setLogradouro(entity.getLogradouro());

        return dto;
    }
}
