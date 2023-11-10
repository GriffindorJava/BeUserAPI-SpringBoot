package school.sptech.projetotophair.domain.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.servico.Servico;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("SELECT s FROM Servico s WHERE s.empresa.idEmpresa = :empresaId")
    List<Servico> findServicosByEmpresaId(@Param("empresaId") Long empresaId);
}
