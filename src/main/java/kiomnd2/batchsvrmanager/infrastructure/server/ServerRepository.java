package kiomnd2.batchsvrmanager.infrastructure.server;

import kiomnd2.batchsvrmanager.domain.server.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Optional<Server> findByToken(String token);
}
