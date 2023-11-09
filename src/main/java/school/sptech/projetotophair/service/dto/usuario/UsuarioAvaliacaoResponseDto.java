package school.sptech.projetotophair.service.dto.usuario;
import lombok.Data;

@Data
public class UsuarioAvaliacaoResponseDto {
    private Long idUsuario;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private Boolean isProfissional;
}