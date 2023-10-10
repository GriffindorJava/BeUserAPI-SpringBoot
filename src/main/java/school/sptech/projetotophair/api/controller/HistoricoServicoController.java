package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;
import school.sptech.projetotophair.service.HistoricoServicoService;

import java.util.Optional;

@RestController
@RequestMapping("/historicoservico")
public class HistoricoServicoController {

    @Autowired
    private HistoricoServicoService historicoServicoService;

    @PostMapping
    public ResponseEntity<HistoricoServico> cadastrar(@RequestBody HistoricoServico historicoServico) {
        HistoricoServico historicoCadastrado = historicoServicoService.cadastrarHistoricoServico(historicoServico);
        return ResponseEntity.status(201).body(historicoCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HistoricoServico>> listar(@PathVariable Long id) {
        Optional<HistoricoServico> historicoServico = historicoServicoService.buscarHistoricoServicoPorId(id);
        return ResponseEntity.ok(historicoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoServico> atualizar(
            @PathVariable Long id,
            @RequestBody HistoricoServico historicoServico
    ) {
        Optional<HistoricoServico> historicoServicoAtualizado = historicoServicoService.atualizarHistoricoServico(id, historicoServico);
        if (historicoServicoAtualizado.isPresent()) {
            return ResponseEntity.status(200).body(historicoServicoAtualizado.get());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHistoricoServico(@PathVariable Long id) {
        historicoServicoService.deletarHistoricoServico(id);
        return ResponseEntity.noContent().build();
    }
}