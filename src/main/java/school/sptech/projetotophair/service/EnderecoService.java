package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.endereco.repository.EnderecoRepository;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public Optional<Endereco> atualizarEndereco(Long id, Endereco endereco) {
        endereco.setIdEndereco(id);
        if (enderecoRepository.existsById(id)) {
            return Optional.of(enderecoRepository.save(endereco));
        }
        return Optional.empty();
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
