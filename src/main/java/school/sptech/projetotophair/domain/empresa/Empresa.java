package school.sptech.projetotophair.domain.empresa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.endereco.Endereco;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @NotBlank
    @Size(min = 4, max = 50)
    private String razaoSocial;
    @CNPJ
    @NotBlank
    @Size(min = 14, max = 14)
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "fkEndereco", referencedColumnName = "idEndereco")
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
