package kiomnd2.batchsvrmanager.interfaces.server;

import kiomnd2.batchsvrmanager.domain.server.Server;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ServerDto {

    @Getter
    @Setter
    @ToString
    public static class RequestCreateServer {
        private String serverId;
        private Integer port;
        private Integer timeout;
        private String encoding;
        private Integer receiveBufferSize;

        public Server toEntity() {
            return Server.builder()
                    .serverId(serverId)
                    .port(port)
                    .timeout(timeout)
                    .encoding(encoding)
                    .buffSize(receiveBufferSize)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class ResponseToken {
        private final String token;
    }

    @Getter
    @Builder
    public static class ResponseInfo {
        private String serverId;
        private Integer port;
        private Integer timeout;
        private String encoding;
        private Integer receiveBufferSize;
    }
}
