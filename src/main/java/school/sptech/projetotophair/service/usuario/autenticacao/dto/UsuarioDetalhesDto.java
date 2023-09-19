package school.sptech.projetotophair.service.usuario.autenticacao.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.util.Collection;

public class UsuarioDetalhesDto implements UserDetails {
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String senha;
    private String telefone;
    private Boolean isProfissional;

    public UsuarioDetalhesDto(Usuario usuario) {
        this.cpf = usuario.getCpf();
        this.nomeCompleto = usuario.getNomeCompleto();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.telefone = usuario.getTelefone();
        this.isProfissional = usuario.getProfissional();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
