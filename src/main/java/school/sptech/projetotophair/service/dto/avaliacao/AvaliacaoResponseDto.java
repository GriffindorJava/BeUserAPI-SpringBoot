package school.sptech.projetotophair.service.dto.avaliacao;

import lombok.Data;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioAvaliacaoResponseDto;

@Data
public class AvaliacaoResponseDto {
    private Long idAvaliacao;
    private Integer nivel;
    private String comentario;
    private UsuarioAvaliacaoResponseDto usuario;
    private EmpresaDto empresaDto;
}
