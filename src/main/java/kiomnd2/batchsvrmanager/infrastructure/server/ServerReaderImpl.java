package kiomnd2.batchsvrmanager.infrastructure.server;

import kiomnd2.batchsvrmanager.common.exception.BaseException;
import kiomnd2.batchsvrmanager.common.response.ErrorCode;
import kiomnd2.batchsvrmanager.domain.server.Server;
import kiomnd2.batchsvrmanager.domain.server.ServerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ServerReaderImpl implements ServerReader {
    private final ServerRepository serverRepository;

    @Override
    public List<Server> readList() {
        return serverRepository.findAll();
    }

    @Override
    public Server read(String token) {
        return serverRepository.findByToken(token).orElseThrow(
                () -> new BaseException(ErrorCode.COMMON_NOTFOUND, "서버"));
    }
}
