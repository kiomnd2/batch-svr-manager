package kiomnd2.batchsvrmanager.domain.server;

import jakarta.transaction.TransactionScoped;
import kiomnd2.batchsvrmanager.interfaces.server.ServerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServerServiceImpl implements ServerService {
    private final ServerStore serverStore;
    private final ServerReader serverReader;

    @Transactional
    @Override
    public String createServer(ServerDto.RequestCreateServer requestCreateServer) {
        Server s = serverStore.store(requestCreateServer.toEntity());
        return s.getToken();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ServerInfo> getServerList() {
        return serverReader.readList().stream().map(Server::toInfo).toList();
    }
}
