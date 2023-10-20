package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;
import school.sptech.projetotophair.domain.endereco.Endereco;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrarEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A empresa não pode ser nula.");
        }
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> buscarEmpresaPorId(Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            return empresaOptional;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada com o ID: " + id);
        }
    }

    public List<Empresa> listarEmpresasPorEstado(String estado) {
        List<Empresa> empresas = empresaRepository.findByEnderecoEstado(estado);
        if (empresas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma empresa encontrada no estado: " + estado);
        }
        return empresas;
    }

    public Optional<Empresa> atualizarEmpresa(Long id, Empresa empresa) {
        if (!empresaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada com o ID: " + id);
        }

        empresa.setIdEmpresa(id);
        Empresa empresaAtualizada = empresaRepository.save(empresa);
        return Optional.of(empresaAtualizada);
    }

    public void deletarEmpresa(Long id) {
        if (!empresaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada com o ID: " + id);
        }
        empresaRepository.deleteById(id);
    }
}
