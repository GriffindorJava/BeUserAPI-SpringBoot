package school.sptech.projetotophair.domain.usuario;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.servico.Servico;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotBlank
    private String cpf;
    @Size(min = 8, max = 80)
    @NotBlank
    private String nomeCompleto;
    @Email
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
    @Size(min = 6, max = 100)
    @NotBlank
    private String senha;
    private String telefone;
    private Boolean isProfissional;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "fkServico", referencedColumnName = "idServico")
    private Servico servico;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "fkAgenda", referencedColumnName = "idAgenda")
    private Agenda agenda;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;
    @Nullable
    @OneToOne
    @JoinColumn(name = "fkEndereco", referencedColumnName = "idEndereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    List<Avaliacao> avaliacoes;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getProfissional() {
        return isProfissional;
    }

    public void setProfissional(Boolean profissional) {
        isProfissional = profissional;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
