package school.sptech.projetotophair.domain.arquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetotophair.domain.arquivo.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}
