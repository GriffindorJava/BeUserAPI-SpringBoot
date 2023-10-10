package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.service.AgendaService;

import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity<Agenda> cadastrar(@RequestBody Agenda agenda) {
        Agenda agendaCadastrada = agendaService.cadastrarAgenda(agenda);
        return ResponseEntity.status(201).body(agendaCadastrada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agenda>> listar(@PathVariable Long id) {
        Optional<Agenda> agenda = agendaService.buscarAgendaPorId(id);
        return ResponseEntity.ok(agenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizar(
            @PathVariable Long id,
            @RequestBody Agenda agenda
    ) {
        Optional<Agenda> agendaAtualizada = agendaService.atualizarAgenda(id, agenda);
        if (agendaAtualizada.isPresent()) {
            return ResponseEntity.status(200).body(agendaAtualizada.get());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Long id) {
        agendaService.deletarAgenda(id);
        return ResponseEntity.noContent().build();
    }
}
