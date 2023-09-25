package school.sptech.projetotophair.domain.historicoservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;

@Repository
public interface HistoricoServicoRepository extends JpaRepository<HistoricoServico, Long> {

}
