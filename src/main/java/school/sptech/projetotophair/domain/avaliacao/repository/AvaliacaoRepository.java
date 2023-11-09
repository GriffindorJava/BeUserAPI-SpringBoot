package school.sptech.projetotophair.domain.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByEmpresaIdEmpresa(Long id);

    List<Avaliacao> findByUsuarioIdUsuario(Long id);
}
