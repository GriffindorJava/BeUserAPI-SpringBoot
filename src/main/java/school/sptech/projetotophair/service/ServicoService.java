package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.servico.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico cadastrarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Optional<Servico> buscarServicoPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public List<Servico> listarTodosServicos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> atualizarServico(Long id, Servico servico) {
        Optional<Servico> servicoExistente = servicoRepository.findById(id);
        if (servicoExistente.isPresent()) {
            servico.setIdServico(id);
            return Optional.of(servicoRepository.save(servico));
        } else {
            return Optional.empty();
        }
    }

    public void deletarServico(Long id) {
        servicoRepository.deleteById(id);
    }
}
