package school.sptech.projetotophair.service.dto.servico;

import lombok.Data;

@Data
public class ServicoDto {
    private String nomeServico;
    private String descricao;
    private Double preco;
    private String qtdTempoServico;
}

