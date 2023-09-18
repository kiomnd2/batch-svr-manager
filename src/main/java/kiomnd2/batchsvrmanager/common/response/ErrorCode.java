package kiomnd2.batchsvrmanager.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해 주세요."),
    COMMON_REQUIRED_VALUE("잘못된 값입니다. [%s]"),
    COMMON_NOTFOUND("[%s] 을 찾을 수 없습니다.");

    private final String message;

    public String getMessage(Object ... arg) {
        return String.format(message, arg);
    }
}