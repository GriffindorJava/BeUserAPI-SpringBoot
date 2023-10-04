package school.sptech.projetotophair.api.controller.usuario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@Valid @RequestBody Empresa empresa) {
        this.empresaRepository.save(empresa);
        return ResponseEntity.status(201).body(empresa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empresa>> listar(@Valid @PathVariable Long id){
        return ResponseEntity.ok(this.empresaRepository.findById(id));
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Empresa>> listarPorEstado(@Valid @RequestParam String estado){
        return ResponseEntity.ok(this.empresaRepository.findByEnderecoEstado(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Empresa empresa
    ) {
        empresa.setIdEmpresa(id);

        if (this.empresaRepository.existsById(id)) {
            Empresa empresaAtualizada = this.empresaRepository.save(empresa);
            return ResponseEntity.status(200).body(empresaAtualizada);
        }

        return ResponseEntity.status(404).build();
    }
}
