package school.sptech.projetotophair.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.service.ServicoService;
import school.sptech.projetotophair.service.dto.servico.ServicoDto;
import school.sptech.projetotophair.service.dto.servico.mapper.ServicoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> cadastrar(@RequestBody Servico servico) {
        Servico servicoCadastrado = servicoService.cadastrarServico(servico);
        return ResponseEntity.status(201).body(servicoCadastrado);
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<ServicoDto>> buscarServicosPorEmpresaId(@PathVariable Long id){
        List<Servico> servicos = servicoService.buscarServicosPorEmpresaId(id);
        List<ServicoDto> dtos = new ArrayList<>();
        for (Servico servicoDaVez: servicos) {
            dtos.add(ServicoMapper.toServicoDto(servicoDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Servico>> listar(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.buscarServicoPorId(id);
        if (servico.isPresent()) {
            return ResponseEntity.ok(servico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarTodos() {
        List<Servico> servicos = servicoService.listarTodosServicos();
        return ResponseEntity.ok(servicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(
            @PathVariable Long id,
            @RequestBody Servico servico
    ) {
        Optional<Servico> servicoAtualizado = servicoService.atualizarServico(id, servico);
            return ResponseEntity.status(200).body(servicoAtualizado.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
