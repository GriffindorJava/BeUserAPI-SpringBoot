package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.service.EmpresaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@RequestBody Empresa empresa) {
        Empresa empresaCadastrada = empresaService.cadastrarEmpresa(empresa);
        return ResponseEntity.status(201).body(empresaCadastrada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empresa>> listar(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaService.buscarEmpresaPorId(id);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Empresa>> listarPorEstado(@RequestParam String estado) {
        List<Empresa> empresasPorEstado = empresaService.listarEmpresasPorEstado(estado);
        return ResponseEntity.ok(empresasPorEstado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(
            @PathVariable Long id,
            @RequestBody Empresa empresa
    ) {
        Optional<Empresa> empresaAtualizada = empresaService.atualizarEmpresa(id, empresa);
            return ResponseEntity.status(200).body(empresaAtualizada.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
