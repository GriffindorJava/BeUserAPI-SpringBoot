package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.agenda.repository.AgendaRepository;

import java.util.Optional;

    @Service
    public class AgendaService {

        @Autowired
        private AgendaRepository agendaRepository;

        public Agenda cadastrarAgenda(Agenda agenda) {
            return agendaRepository.save(agenda);
        }

        public Optional<Agenda> buscarAgendaPorId(Long id) {
            return agendaRepository.findById(id);
        }

        public Optional<Agenda> atualizarAgenda(Long id, Agenda agenda) {
            agenda.setIdAgenda(id);
            if (agendaRepository.existsById(id)) {
                return Optional.of(agendaRepository.save(agenda));
            }
            return Optional.empty();
        }

        public void deletarAgenda(Long id) {
            agendaRepository.deleteById(id);
        }
    }
