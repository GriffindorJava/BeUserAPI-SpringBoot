package school.sptech.projetotophair.domain.historicoservico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import school.sptech.projetotophair.domain.agenda.Agenda;


@Entity
public class HistoricoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoricoServico;
    @NotNull
    private Integer ano;
    @NotNull
    private Integer mes;
    @NotNull
    private Integer semana;
    @NotNull
    private Double faturamento;

    @OneToOne
    @JoinColumn(name = "fkAgenda", referencedColumnName = "idAgenda")
    private Agenda agenda;

    public Long getIdHistoricoServico() {
        return idHistoricoServico;
    }

    public void setIdHistoricoServico(Long idHistoricoServico) {
        this.idHistoricoServico = idHistoricoServico;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
