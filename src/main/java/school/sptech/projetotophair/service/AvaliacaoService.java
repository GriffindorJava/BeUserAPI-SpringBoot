package school.sptech.projetotophair.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.domain.avaliacao.repository.AvaliacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A avaliação não pode ser nula.");
        }
        return avaliacaoRepository.save(avaliacao);
    }

    public Optional<Avaliacao> buscarAvaliacaoPorId(Long id) {
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
        if (avaliacaoOptional.isPresent()) {
            return avaliacaoOptional;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada com o ID: " + id);
    }

    public List<Avaliacao> findAvaliacoesByEmpresaId(Long id) {
        List<Avaliacao> avaliacoesPorEmpresaId = avaliacaoRepository.findByEmpresaIdEmpresa(id);

        if (avaliacoesPorEmpresaId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada com o ID: " + id);
        }
        return avaliacoesPorEmpresaId;
    }

    public List<Avaliacao> findAvaliacoesByUsuarioId(Long id) {
        List<Avaliacao> avaliacoesPorUsuarioId = avaliacaoRepository.findByUsuarioIdUsuario(id);

        if (avaliacoesPorUsuarioId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrada com o ID: " + id);
        }
        return avaliacoesPorUsuarioId;
    }

    public Avaliacao atualizarAvaliacaoPorId(Long id, Avaliacao avaliacao){
        Optional<Avaliacao> byId = avaliacaoRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada com o ID: " + id);
        }
        return avaliacaoRepository.save(avaliacao);
    }

    public void deletarAvaliacaoPorId(Long id){
        Optional<Avaliacao> byId = avaliacaoRepository.findById(id);

        if (byId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada com o ID: " + id);
        }

        avaliacaoRepository.deleteById(id);
    }
}
