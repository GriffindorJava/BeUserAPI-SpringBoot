package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.agenda.repository.AgendaRepository;

import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda cadastrarAgenda(Agenda agenda) {
        if (agenda == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A agenda não pode ser nula.");
        }
        return agendaRepository.save(agenda);
    }

    public Optional<Agenda> buscarAgendaPorId(Long id) {
        Optional<Agenda> agendaOptional = agendaRepository.findById(id);
        if (agendaOptional.isPresent()) {
            return agendaOptional;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada com o ID: " + id);
        }
    }

    public Optional<Agenda> atualizarAgenda(Long id, Agenda agenda) {
        if (!agendaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada com o ID: " + id);
        }

        agenda.setIdAgenda(id);

        agenda = agendaRepository.save(agenda);

        return Optional.of(agenda);
    }

    public void deletarAgenda(Long id) {
        if (!agendaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada com o ID: " + id);
        }
        agendaRepository.deleteById(id);
    }
}
