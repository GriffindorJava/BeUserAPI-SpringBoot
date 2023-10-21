package school.sptech.projetotophair.domain.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    @Size(min = 3, max = 50)
    private String logradouro;

    private Integer numero;
    @Size(min = 3, max = 30)
    private String estado;
    @Size(min = 3, max = 30)
    private String complemento;
    @Size(min = 3, max = 30)
    private String cidade;
    @Size(min = 9, max = 9)
    private String cep;

    public Endereco(Long idEndereco, String logradouro, Integer numero, String estado, String complemento, String cidade, String cep) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.estado = estado;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
