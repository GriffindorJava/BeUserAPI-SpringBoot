package school.sptech.projetotophair.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.agenda.repository.AgendaRepository;

import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @PostMapping
    public ResponseEntity<Agenda> cadastrar(@Valid @RequestBody Agenda agenda) {
        this.agendaRepository.save(agenda);
        return ResponseEntity.status(200).body(agenda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agenda>> listar(@Valid @PathVariable Long id){
        return ResponseEntity.ok(this.agendaRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Agenda agenda
    ) {
        agenda.setIdAgenda(id);

        if (this.agendaRepository.existsById(id)) {
            Agenda agendaAtualizada = this.agendaRepository.save(agenda);
            return ResponseEntity.status(200).body(agendaAtualizada);
        }

        return ResponseEntity.status(404).build();
    }
}
