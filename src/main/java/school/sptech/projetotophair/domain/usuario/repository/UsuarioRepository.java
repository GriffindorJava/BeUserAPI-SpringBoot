package school.sptech.projetotophair.domain.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    @Query("SELECT u FROM Usuario u JOIN u.avaliacoes a WHERE a.idAvaliacao = :avaliacaoId")
    Usuario findByAvaliacaoId(@Param("avaliacaoId") Long avaliacaoId);
}
