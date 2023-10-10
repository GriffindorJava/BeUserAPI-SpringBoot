package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> buscarEmpresaPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public List<Empresa> listarEmpresasPorEstado(String estado) {
        return empresaRepository.findByEnderecoEstado(estado);
    }

    public Optional<Empresa> atualizarEmpresa(Long id, Empresa empresa) {
        empresa.setIdEmpresa(id);
        if (empresaRepository.existsById(id)) {
            return Optional.of(empresaRepository.save(empresa));
        }
        return Optional.empty();
    }

    public void deletarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
