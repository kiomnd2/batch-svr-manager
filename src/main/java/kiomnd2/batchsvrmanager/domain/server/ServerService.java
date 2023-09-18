package kiomnd2.batchsvrmanager.domain.server;

import kiomnd2.batchsvrmanager.interfaces.server.ServerDto;

import java.util.List;

public interface ServerService {
    String createServer(ServerDto.RequestCreateServer requestCreateServer);

    List<ServerInfo> getServerList();
}
