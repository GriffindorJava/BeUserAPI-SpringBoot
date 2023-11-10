package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.servico.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico cadastrarServico(Servico servico) {
        try {
            return servicoRepository.save(servico);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao cadastrar o serviço", e);
        }
    }

    public List<Servico> buscarServicosPorEmpresaId(Long id){
        List<Servico> servicosByEmpresaId = servicoRepository.findServicosByEmpresaId(id);

        if (servicosByEmpresaId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviços não encontrados para essa empresa");
        }

        return servicosByEmpresaId;
    }

    public Optional<Servico> buscarServicoPorId(Long id) {
        try {
            Optional<Servico> servico = servicoRepository.findById(id);
            if (servico.isPresent()) {
                return servico;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar o serviço por ID", e);
        }
    }

    public List<Servico> listarTodosServicos() {
        try {
            return servicoRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao listar todos os serviços", e);
        }
    }

    public Optional<Servico> atualizarServico(Long id, Servico servico) {
        try {
            Optional<Servico> servicoExistente = servicoRepository.findById(id);
            if (servicoExistente.isPresent()) {
                servico.setIdServico(id);
                return Optional.of(servicoRepository.save(servico));
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar o serviço", e);
        }
    }

    public void deletarServico(Long id) {
        try {
            servicoRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar o serviço", e);
        }
    }
}
