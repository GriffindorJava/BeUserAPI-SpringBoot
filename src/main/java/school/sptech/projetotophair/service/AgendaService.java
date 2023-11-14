package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.api.pilha.PilhaObj;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.agenda.repository.AgendaRepository;

import java.util.ArrayList;
import java.util.List;
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

    public PilhaObj<Agenda> getUltimosAgendamentos() {
        int quantidadeDesejada = 10;

        PilhaObj<Agenda> ultimosAgendamentosPilha = new PilhaObj<>(quantidadeDesejada);

        // Popula a pilha com os últimos agendamentos do banco de dados
        List<Agenda> todosAgendamentos = agendaRepository.findAll();
        for (Agenda agendamento : todosAgendamentos) {
            ultimosAgendamentosPilha.push(agendamento);
        }

        // Inverte a ordem dos agendamentos na pilha
        inverterOrdemPilha(ultimosAgendamentosPilha);

        // Retorna a pilha invertida
        return ultimosAgendamentosPilha;
    }

    // Método para inverter a ordem dos elementos na pilha
    private <T> void inverterOrdemPilha(PilhaObj<T> pilha) {
        int tamanho = pilha.getTopo() + 1;
        for (int i = 0; i < tamanho / 2; i++) {
            T temp = pilha.pop();
            pilha.push(pilha.pop());
            pilha.push(temp);
        }

}





}
