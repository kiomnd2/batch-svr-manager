package kiomnd2.batchsvrmanager.interfaces.server;

import kiomnd2.batchsvrmanager.application.server.ServerFacade;
import kiomnd2.batchsvrmanager.common.response.CommonResponse;
import kiomnd2.batchsvrmanager.domain.server.ServerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/server")
public class ServerApi {
    private final ServerFacade serverService;

    @PostMapping("/")
    public CommonResponse<ServerDto.ResponseToken> createServer(@RequestBody ServerDto.RequestCreateServer request) {
        String token = serverService.createServer(request);
        return CommonResponse.success(ServerDto.ResponseToken.builder().token(token).build());
    }

    @GetMapping("/")
    public CommonResponse<List<ServerDto.ResponseInfo>> getServerList() {
        List<ServerInfo> serverList = serverService.getServerList();
        List<ServerDto.ResponseInfo> list = serverList.stream().map(ServerInfo::toDto).toList();
        return CommonResponse.success(list);
    }

}
