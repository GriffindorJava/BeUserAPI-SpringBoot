package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;
import school.sptech.projetotophair.domain.historicoservico.repository.HistoricoServicoRepository;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HistoricoServicoService {

    @Autowired
    private HistoricoServicoRepository historicoServicoRepository;

    public HistoricoServico cadastrarHistoricoServico(HistoricoServico historicoServico) {
        if (historicoServico == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O histórico de serviço não pode ser nulo.");
        }
        return historicoServicoRepository.save(historicoServico);
    }

    public Optional<HistoricoServico> buscarHistoricoServicoPorId(Long id) {
        Optional<HistoricoServico> historicoOptional = historicoServicoRepository.findById(id);
        if (historicoOptional.isPresent()) {
            return historicoOptional;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico de serviço não encontrado com o ID: " + id);
        }
    }

    public Optional<HistoricoServico> atualizarHistoricoServico(Long id, HistoricoServico historicoServico) {
        if (!historicoServicoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico de serviço não encontrado com o ID: " + id);
        }

        historicoServico.setIdHistoricoServico(id);

        HistoricoServico historicoServicoAtualizado = historicoServicoRepository.save(historicoServico);

        return Optional.of(historicoServicoAtualizado);
    }

    public void deletarHistoricoServico(Long id) {
        if (!historicoServicoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico de serviço não encontrado com o ID: " + id);
        }
        historicoServicoRepository.deleteById(id);
    }
}
