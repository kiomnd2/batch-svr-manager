package kiomnd2.batchsvrmanager.domain.server;

import kiomnd2.batchsvrmanager.interfaces.server.ServerDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@RequiredArgsConstructor
public class ServerInfo {
    private final String serverId;
    private final String token;
    private final Integer port;
    private final Integer timeout;
    private final String encoding;
    private final Integer buffSize;

    public ServerDto.ResponseInfo toDto() {
        return ServerDto.ResponseInfo.builder()
                .serverId(serverId)
                .timeout(timeout)
                .port(port)
                .encoding(encoding)
                .receiveBufferSize(buffSize)
                .build();
    }
}
