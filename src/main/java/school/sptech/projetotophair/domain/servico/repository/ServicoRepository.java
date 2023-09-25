package school.sptech.projetotophair.domain.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.servico.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
