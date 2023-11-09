package school.sptech.projetotophair.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.service.AvaliacaoService;
import school.sptech.projetotophair.service.dto.avaliacao.AvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.avaliacao.mapper.AvaliacaoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDto> cadastrarAvaliacao(@RequestBody @Valid Avaliacao avaliacao){
        this.avaliacaoService.cadastrarAvaliacao(avaliacao);
        return ResponseEntity.status(201).body(AvaliacaoMapper.toAvaliacaoResponseDto(avaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDto> atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        this.avaliacaoService.atualizarAvaliacaoPorId(id, avaliacao);
        Optional<Avaliacao> avaliacaoPorId = avaliacaoService.buscarAvaliacaoPorId(id);
        AvaliacaoResponseDto avaliacaoResponseDto = AvaliacaoMapper.toAvaliacaoResponseDto(avaliacaoPorId.get());
        return ResponseEntity.ok(avaliacaoResponseDto);
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<AvaliacaoResponseDto>> buscarAvaliacoesPorEmpresaId(Long id){
        List<Avaliacao> avaliacoesByEmpresaId = this.avaliacaoService.findAvaliacoesByEmpresaId(id);

        if (avaliacoesByEmpresaId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AvaliacaoResponseDto> dtos = new ArrayList<>();
        for (Avaliacao avaliacaoDaVez: avaliacoesByEmpresaId) {
            dtos.add(AvaliacaoMapper.toAvaliacaoResponseDto(avaliacaoDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<AvaliacaoResponseDto>> buscarAvaliacoesPorUsuarioId(Long id){
        List<Avaliacao> avaliacoesByEmpresaId = this.avaliacaoService.findAvaliacoesByUsuarioId(id);

        if (avaliacoesByEmpresaId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AvaliacaoResponseDto> dtos = new ArrayList<>();
        for (Avaliacao avaliacaoDaVez: avaliacoesByEmpresaId) {
            dtos.add(AvaliacaoMapper.toAvaliacaoResponseDto(avaliacaoDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        this.avaliacaoService.deletarAvaliacaoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
