package school.sptech.projetotophair.service.dto.mapper;

import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.dto.UltimosAgendamentosDto;

public class UltimosAgendamentosMapper {

    public static UltimosAgendamentosDto toDto(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UltimosAgendamentosDto dto = new UltimosAgendamentosDto();
        dto.setNomeCompleto(usuario.getNomeCompleto());

        if (usuario.getServico().getAgenda() != null) {
            Agenda agenda = usuario.getServico().getAgenda();
            dto.setHora(agenda.getHora());
            dto.setData(agenda.getData());
            dto.setStatus(agenda.getStatus());
        }
        return dto;
    }
}
