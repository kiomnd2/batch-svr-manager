package kiomnd2.batchsvrmanager.domain.server;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import kiomnd2.batchsvrmanager.common.exception.InvalidParamException;
import kiomnd2.batchsvrmanager.common.utils.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Server {

    @Transient
    private final String prefix = "server_";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SVR_ID", unique = true)
    private String serverId;

    @Column(name = "TOKEN", unique = true)
    private String token;

    @Column(name = "SVR_PORT")
    private Integer port;

    @Column(name = "SVR_TMOUT")
    private Integer timeout;

    @Column(name = "ENCODING")
    private String encoding;

    @Column(name = "BUFF_SIZE")
    private Integer buffSize;

    @Builder
    public Server(String serverId, Integer port, Integer timeout, String encoding, Integer buffSize) {
        token = TokenGenerator.randomCharacterWithPrefix(prefix);
        if (StringUtils.isBlank(serverId)) throw new InvalidParamException("server.serverId is null");
        if (port == null) throw new InvalidParamException("server.port is null");
        if (timeout == null) timeout = 60000;
        if (StringUtils.isBlank(encoding)) encoding = "UTF-8";
        if (buffSize == 0) buffSize = 1024;

        this.serverId = serverId;
        this.port = port;
        this.timeout = timeout;
        this.encoding = encoding;
        this.buffSize = buffSize;
    }

    public ServerInfo toInfo() {
        return ServerInfo.builder()
                .serverId(serverId)
                .token(token)
                .timeout(timeout)
                .encoding(encoding)
                .buffSize(buffSize)
                .port(port)
                .build();
    }
}
