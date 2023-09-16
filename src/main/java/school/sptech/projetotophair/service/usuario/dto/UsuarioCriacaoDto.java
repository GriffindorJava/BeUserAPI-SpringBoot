package school.sptech.projetotophair.service.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioCriacaoDto {
    private String cpf;
    private String nomeCompleto;
    @Email
    private String email;
    @Size(min = 6, max = 20)
    private String senha;
    private String telefone;
    private Boolean isProfissional;

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
}
