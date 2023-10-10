package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;
import school.sptech.projetotophair.domain.historicoservico.repository.HistoricoServicoRepository;


import java.util.Optional;

@Service
public class HistoricoServicoService {

    @Autowired
    private HistoricoServicoRepository historicoServicoRepository;

    public HistoricoServico cadastrarHistoricoServico(HistoricoServico historicoServico) {
        return historicoServicoRepository.save(historicoServico);
    }

    public Optional<HistoricoServico> buscarHistoricoServicoPorId(Long id) {
        return historicoServicoRepository.findById(id);
    }

    public Optional<HistoricoServico> atualizarHistoricoServico(Long id, HistoricoServico historicoServico) {
        historicoServico.setIdHistoricoServico(id);
        if (historicoServicoRepository.existsById(id)) {
            return Optional.of(historicoServicoRepository.save(historicoServico));
        }
        return Optional.empty();
    }

    public void deletarHistoricoServico(Long id) {
        historicoServicoRepository.deleteById(id);
    }
}
