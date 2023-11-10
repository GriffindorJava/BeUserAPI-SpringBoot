package school.sptech.projetotophair.service.dto.endereco;

import lombok.Data;

@Data
public class EnderecoDto {
    private String logradouro;
    private Integer numero;
    private String estado;
    private String complemento;
    private String cidade;
    private String cep;
}

