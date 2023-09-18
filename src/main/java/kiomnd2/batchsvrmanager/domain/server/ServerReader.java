package kiomnd2.batchsvrmanager.domain.server;

import java.util.List;

public interface ServerReader {
    List<Server> readList();
    Server read(String token);
}
