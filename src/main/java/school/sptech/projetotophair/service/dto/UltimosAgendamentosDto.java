package school.sptech.projetotophair.service.dto;

import java.time.LocalDate;

public class UltimosAgendamentosDto {
    private String nomeCompleto;
    private LocalDate data;
    private String hora;
    private String status;

    public UltimosAgendamentosDto(String nomeCompleto, LocalDate data, String hora, String status) {
        this.nomeCompleto = nomeCompleto;
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public UltimosAgendamentosDto() {

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
