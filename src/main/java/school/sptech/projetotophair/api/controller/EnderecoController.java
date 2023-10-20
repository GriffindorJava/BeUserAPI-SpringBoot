package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.service.EnderecoService;

import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
        Endereco enderecoCadastrado = enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.status(201).body(enderecoCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> listar(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(
            @PathVariable Long id,
            @RequestBody Endereco endereco
    ) {
        Optional<Endereco> enderecoAtualizado = enderecoService.atualizarEndereco(id, endereco);
            return ResponseEntity.status(200).body(enderecoAtualizado.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}