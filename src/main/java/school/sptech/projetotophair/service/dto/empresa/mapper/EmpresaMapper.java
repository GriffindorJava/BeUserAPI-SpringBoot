package school.sptech.projetotophair.service.dto.empresa.mapper;

import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

public class EmpresaMapper {
    public static EmpresaDto toEmpresaDto(Empresa entity){
        EmpresaDto dto = new EmpresaDto();

        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setCnpj(entity.getCnpj());
        dto.setRazaoSocial(entity.getRazaoSocial());

        return dto;
    }
}
