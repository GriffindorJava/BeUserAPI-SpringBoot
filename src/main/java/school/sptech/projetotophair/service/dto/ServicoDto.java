package school.sptech.projetotophair.service.dto;

public class ServicoDto {
    private String nomeServico;
    private String descricao;
    private Double preco;
    private String qtdTempoServico;

    public ServicoDto(String nomeServico, String descricao, Double preco, String qtdTempoServico) {
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdTempoServico = qtdTempoServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getQtdTempoServico() {
        return qtdTempoServico;
    }

    public void setQtdTempoServico(String qtdTempoServico) {
        this.qtdTempoServico = qtdTempoServico;
    }
}

