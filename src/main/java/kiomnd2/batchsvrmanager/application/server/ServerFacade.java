package kiomnd2.batchsvrmanager.application.server;

import kiomnd2.batchsvrmanager.domain.server.ServerInfo;
import kiomnd2.batchsvrmanager.domain.server.ServerService;
import kiomnd2.batchsvrmanager.interfaces.server.ServerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServerFacade {
    private final ServerService serverService;
    public String createServer(ServerDto.RequestCreateServer request) {
        return serverService.createServer(request);
    }

    public List<ServerInfo> getServerList() {
        return serverService.getServerList();
    }
}
