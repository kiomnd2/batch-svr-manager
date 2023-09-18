package kiomnd2.batchsvrmanager.infrastructure.server;

import kiomnd2.batchsvrmanager.domain.server.ServerStore;
import kiomnd2.batchsvrmanager.domain.server.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ServerStoreImpl implements ServerStore {
    private final ServerRepository serverRepository;

    @Override
    public Server store(Server server) {
        return serverRepository.save(server);
    }
}
