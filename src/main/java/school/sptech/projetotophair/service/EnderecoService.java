package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.endereco.repository.EnderecoRepository;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O endereço não pode ser nulo.");
        }
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> buscarEnderecoPorId(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            return enderecoOptional;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado com o ID: " + id);
        }
    }

    public Optional<Endereco> atualizarEndereco(Long id, Endereco endereco) {
        if (!enderecoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado com o ID: " + id);
        }
        endereco.setIdEndereco(id);
        Endereco enderecoAtualizado = enderecoRepository.save(endereco);
        return Optional.of(enderecoAtualizado);
    }

    public void deletarEndereco(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado com o ID: " + id);
        }
        enderecoRepository.deleteById(id);
    }
}
