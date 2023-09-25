package school.sptech.projetotophair.domain.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.agenda.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
