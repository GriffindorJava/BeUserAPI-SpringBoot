package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.api.pilha.PilhaObj;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;
import school.sptech.projetotophair.service.AgendaService;
import school.sptech.projetotophair.service.dto.agenda.UltimosAgendamentosDto;
import school.sptech.projetotophair.service.dto.agenda.mapper.UltimosAgendamentosMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private UsuarioRepository u;

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
            return ResponseEntity.status(200).body(agendaAtualizada.get());
    }

//    @GetMapping("/ultimos-agendamentos/{id}")
//    public ResponseEntity<UltimosAgendamentosDto> ultimosAgendamentos(@PathVariable Long id){
//        Optional<Usuario> all = u.findById(id);
//
//        if (all.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        UltimosAgendamentosDto dto = UltimosAgendamentosMapper.toDto(all.get());
//
//        return ResponseEntity.ok(dto);
//    }

    @GetMapping("/ultimos-agendamentos/{id}")
    public ResponseEntity<PilhaObj<Agenda>> ultimosAgendamentos(@PathVariable Long id){
        Optional<Usuario> all = u.findById(id);

        if (all.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Obtendo os últimos agendamentos da pilha
        PilhaObj<Agenda> ultimosAgendamentos = agendaService.getUltimosAgendamentos();
        UltimosAgendamentosDto dto = UltimosAgendamentosMapper.toDto(all.get());

        return ResponseEntity.ok(ultimosAgendamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Long id) {
        agendaService.deletarAgenda(id);
        return ResponseEntity.noContent().build();
    }
}
